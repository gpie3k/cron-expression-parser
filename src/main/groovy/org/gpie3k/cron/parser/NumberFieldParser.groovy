package org.gpie3k.cron.parser

class NumberFieldParser implements FieldParser {

    def rules = [
            '^[0-9]+(,[0-9]+)*$': NumberFieldParser.&parseValues as FieldParser,
            '^\\*$': NumberFieldParser.&parseAsteriks as FieldParser,
            '^[0-9]+-[0-9]+$': NumberFieldParser.&parseRange as FieldParser,
            '^(\\*|[0-9]+)/[0-9]+$': NumberFieldParser.&parseEvery as FieldParser,
    ]

    @Override
    def parse(FieldData data, String input) {
        rules.find({
            input ==~ it.key
        })?.value?.parse(data, input)?.findAll(NumberFieldParser.&validate)?.sort() ?: [] as int[]
    }

    static validate(FieldData data, int input) {
        input in data.min()..data.max()
    }

    static int[] parseValues(FieldData data, String input) {
        input.split(',').sort().collect(Integer.&parseInt)
    }

    static int[] parseAsteriks(FieldData data, String input) {
        data.min()..data.max()
    }

    static int[] parseRange(FieldData data, String input) {
        def strings = input.split('-').sort()
        def first = Integer.parseInt(strings.first())
        def last = Integer.parseInt(strings.last())
        first..last
    }

    static int[] parseEvery(FieldData data, String input) {
        def strings = input.split('/')
        def first = strings.first() == '*' ? 0 : Integer.parseInt(strings.first())
        def last = Integer.parseInt(strings.last())
        (data.min()..data.max()).findAll({it % last == first})
    }

}
