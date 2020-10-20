package org.gpie3k.cron.parser.field

import org.gpie3k.cron.parser.model.Data

class NumberFieldParser implements FieldParser {

    def rules = [
            '^[0-9]+(,[0-9]+)*$'   : NumberFieldParser.&parseValues as FieldParser,
            '^\\*$'                : NumberFieldParser.&parseAsteriks as FieldParser,
            '^[0-9]+-[0-9]+$'      : NumberFieldParser.&parseRange as FieldParser,
            '^(\\*|[0-9]+)/[0-9]+$': NumberFieldParser.&parseEvery as FieldParser,
    ]

    @Override
    def parse(Data data, String input) {
        rules.find({
            input ==~ it.key
        })?.value?.parse(data, input)?.findAll(NumberValidator.&validate.curry(data))?.sort() ?: [] as int[]
    }

    static int[] parseValues(Data data, String input) {
        input.split(',').sort().collect(Integer.&parseInt)
    }

    static int[] parseAsteriks(Data data, String input) {
        data.min()..data.max()
    }

    static int[] parseRange(Data data, String input) {
        def strings = input.split('-').sort()
        def first = Integer.parseInt(strings.first())
        def last = Integer.parseInt(strings.last())
        first..last
    }

    static int[] parseEvery(Data data, String input) {
        def strings = input.split('/')
        def first = strings.first() == '*' ? 0 : Integer.parseInt(strings.first())
        def last = Integer.parseInt(strings.last())
        (data.min()..data.max()).findAll({ it % last == first })
    }

}
