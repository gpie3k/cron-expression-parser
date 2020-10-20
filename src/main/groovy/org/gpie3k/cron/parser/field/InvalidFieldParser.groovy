package org.gpie3k.cron.parser.field

import org.gpie3k.cron.parser.model.Data

class InvalidFieldParser implements FieldParser {
    @Override
    def parse(Data data, String input) {
        throw new RuntimeException("Invalid format: ${input}")
    }
}
