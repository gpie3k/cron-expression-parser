package org.gpie3k.cron.parser

import spock.lang.Specification
import spock.lang.Unroll

class OutputTest extends Specification {
    def output = new Output()

    @Unroll
    def "should format result"() {
        when:
        def res = output.format(result)

        then:
        res == out

        where:
        result | out
        new Result(minute: [0], hour: [0], day: [0], month: [0], dayOfWeek: [0], command: "test") | 'minute        0\nhour          0\nday of month  0\nmonth         0\nday of week   0\ncommand       test'
    }
}
