package org.gpie3k.cron.parser

interface FieldParser {
    def parse(FieldData data, String input)
}