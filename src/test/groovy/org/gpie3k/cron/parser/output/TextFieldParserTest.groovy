package org.gpie3k.cron.parser.output

import org.gpie3k.cron.parser.field.TextFieldParser
import spock.lang.Specification
import spock.lang.Unroll

class TextFieldParserTest extends Specification {
    def parser = new TextFieldParser()

    @Unroll
    def "should parse input"() {

        expect:
        parser.parse(null, req) == res

        where:
        req    | res
        ""     | ""
        "test" | "test"
    }
}
