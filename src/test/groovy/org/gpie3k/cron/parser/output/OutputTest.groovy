package org.gpie3k.cron.parser.output

import org.gpie3k.cron.parser.model.Result
import org.gpie3k.cron.parser.output.Output
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
        result                                                                                    | out
        new Result(minute: [0], hour: [0], day: [1], month: [1], dayOfWeek: [1], command: "test") | 'minute        0\nhour          0\nday of month  1\nmonth         1\nday of week   1\ncommand       test'
    }
}