package org.gpie3k.cron.parser.field

import org.gpie3k.cron.parser.model.Data
import spock.lang.Specification
import spock.lang.Unroll

class DayOfWeekFieldParserTest extends Specification {
    def parser = new DayOfWeekFieldParser()

    def data = Mock(Data)

    @Unroll
    def "should parse number"() {
        given:
        data.min() >> 0
        data.max() >> 5

        expect:
        parser.parse(data, req) == res

        where:
        req       | res
        '1'       | [1]
        '3,1'     | [1, 3]
        '*'       | 0..5
        '1-2'     | [1, 2]
        '*/2'     | [0, 2, 4]
        '1/3'     | [1, 4]
        'WED'     | [3]
        'TUE-WED' | [2, 3]
        'FRI-TUE' | [0, 1, 2, 5]
    }

    @Unroll
    def "should parse invalid number #req"() {
        given:
        data.min() >> 0
        data.max() >> 5

        when:
        parser.parse(data, req)

        then:
        def ex = thrown(Exception)
        ex.message == "Invalid input: ${req}"

        where:
        req << ['', 'test', null, '2-1', '2//3', ' * ']
    }
}
