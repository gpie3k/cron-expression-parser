package org.gpie3k.cron.parser

import org.gpie3k.cron.parser.model.Result
import spock.lang.Specification
import spock.lang.Unroll

class ParserTest extends Specification {
    @Unroll
    def "should parse input #req"() {

        expect:
        Parser.parse(req) == res

        where:
        req                       | res
        '0 0 1 1 1 /exec'         | new Result(minute: [0], hour: [0], day: [1], month: [1], dayOfWeek: [1], command: '/exec')
        '*/15 0 1,15 * 1-5 /exec' | new Result(minute: [0, 15, 30, 45], hour: [0], day: [1, 15], month: 1..12, dayOfWeek: 1..5, command: '/exec')
    }
}
