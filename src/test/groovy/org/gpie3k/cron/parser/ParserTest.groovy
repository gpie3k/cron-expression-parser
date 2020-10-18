package org.gpie3k.cron.parser

import spock.lang.Specification

class ParserTest extends Specification {
    def "should parse input"() {

        expect:
        Parser.parse(req) == res

        where:
        req               | res
        '0 0 0 0 0 /exec' | new Result(minute: [0], hour: [0], day: [0], month: [0], dayOfWeek: [0], command: '/exec')
    }
}
