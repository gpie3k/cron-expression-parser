package org.gpie3k.cron.parser.field

import org.gpie3k.cron.parser.model.Data
import spock.lang.Specification
import spock.lang.Unroll

class NumberValidatorTest extends Specification {
    def data = Mock(Data)

    @Unroll
    def "should validate number"() {
        given:
        data.min() >> 4
        data.max() >> 8

        expect:
        NumberValidator.validate(data, req) == res

        where:
        req | res
        3   | false
        4   | true
        8   | true
        9   | false
    }
}
