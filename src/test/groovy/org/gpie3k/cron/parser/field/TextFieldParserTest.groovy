package org.gpie3k.cron.parser.field

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
