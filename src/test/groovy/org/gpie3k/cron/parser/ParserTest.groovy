package org.gpie3k.cron.parser

import org.gpie3k.cron.parser.model.Result
import spock.lang.Specification

class ParserTest extends Specification {
    def "should parse input"() {

        expect:
        Parser.parse(req) == res

        where:
        req               | res
        '0 0 1 1 1 /exec' | new Result(minute: [0], hour: [0], day: [1], month: [1], dayOfWeek: [1], command: '/exec')
    }
}
