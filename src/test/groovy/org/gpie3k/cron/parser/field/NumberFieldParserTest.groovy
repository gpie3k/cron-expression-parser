package org.gpie3k.cron.parser.field

import org.gpie3k.cron.parser.field.NumberFieldParser
import org.gpie3k.cron.parser.model.Data
import spock.lang.Specification
import spock.lang.Unroll

class NumberFieldParserTest extends Specification {
    def parser = new NumberFieldParser()

    def data = Mock(Data)

    @Unroll
    def "should parse number"() {
        given:
        data.min() >> 0
        data.max() >> 5

        expect:
        parser.parse(data, req) == res as int[]

        where:
        req   | res
        '1'   | [1]
        '3,1' | [1, 3]
        '*'   | [0, 1, 2, 3, 4, 5]
        '1-2' | [1, 2]
        '*/2' | [0, 2, 4]
        '1/3' | [1, 4]
        '2-1' | [1, 2]
        '8,1' | [1]
    }
}
