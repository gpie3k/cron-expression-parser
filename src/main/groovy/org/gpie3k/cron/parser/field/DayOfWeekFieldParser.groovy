package org.gpie3k.cron.parser.field

import org.gpie3k.cron.parser.model.Data

class DayOfWeekFieldParser implements FieldParser {

    def rules = [
            '^[0-9]+(,[0-9]+)*$'   : DayOfWeekFieldParser.&parseValues as FieldParser,
            '^\\*$'                : DayOfWeekFieldParser.&parseAsteriks as FieldParser,
            '^[0-9]+-[0-9]+$'      : DayOfWeekFieldParser.&parseRange as FieldParser,
            '^(\\*|[0-9]+)/[0-9]+$': DayOfWeekFieldParser.&parseEvery as FieldParser,
    ]

    @Override
    def parse(Data data, String input) {
        def validate = NumberValidator.&validate.curry(data)
        rules.find({
            input ==~ it.key
        })?.value?.parse(data, input)?.findAll(validate)?.sort() ?: invalidInput(input)
    }

    static invalidInput(String input) {
        throw new RuntimeException("Invalid input: ${input}")
    }

    static int[] parseValues(Data data, String input) {
        input.split(',').sort().collect(Integer.&parseInt)
    }

    static int[] parseAsteriks(Data data, String input) {
        data.min()..data.max()
    }

    static int[] parseRange(Data data, String input) {
        def strings = input.split('-')
        def first = Integer.parseInt(strings.first())
        def last = Integer.parseInt(strings.last())
        first <= last ? first..last : invalidInput(input)
    }

    static int[] parseEvery(Data data, String input) {
        def strings = input.split('/')
        def first = strings.first() == '*' ? 0 : Integer.parseInt(strings.first())
        def last = Integer.parseInt(strings.last())
        (data.min()..data.max()).findAll({ it % last == first })
    }

}
