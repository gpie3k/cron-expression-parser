package org.gpie3k.cron.parser.field

import org.gpie3k.cron.parser.model.Data

interface FieldParser {
    def parse(Data data, String input)
}