package org.gpie3k.cron.parser.output

import org.gpie3k.cron.parser.model.Result
import spock.lang.Specification
import spock.lang.Unroll

class OutputTest extends Specification {

    @Unroll
    def "should format result"() {
        when:
        def res = Output.format(result)

        then:
        res == out

        where:
        result                                                                                       | out
        new Result(minute: [1], hour: [2], day: [3], month: [4], dayOfWeek: [5, 6], command: "test") | 'minute        1\nhour          2\nday of month  3\nmonth         4\nday of week   5 6\ncommand       test'
    }
}
