package org.gpie3k.cron.parser.field

import org.gpie3k.cron.parser.model.Data
import spock.lang.Specification
import spock.lang.Unroll

class NumberValidatorTest extends Specification {
    def data = Mock(Data)

    @Unroll
    def "should validate number #req"() {
        given:
        data.min() >> 4
        data.max() >> 8

        expect:
        NumberValidator.validate(data, req) == res

        where:
        req | res
        4   | true
        8   | true
    }

    @Unroll
    def "should validate invalid number #req"() {
        given:
        data.min() >> 4
        data.max() >> 8

        when:
        NumberValidator.validate(data, req)

        then:
        thrown(Exception)

        where:
        req << [3, 9]
    }
}
