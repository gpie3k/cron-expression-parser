package org.gpie3k.cron.parser

import static java.lang.Integer.parseInt

class NumberFieldParser implements FieldParser {
    @Override
    def parse(FieldData data, String input) {
        [parseInt(input)] as int[]
    }
}
