package org.gpie3k.cron.parser

import spock.lang.Specification
import spock.lang.Unroll

class AppTest extends Specification {

    @Unroll
    def "should execute app #req"() {
        expect:
        App.main(req as String[])

        where:
        req << [
                ["0 0 1 1 1 test"],
                ["*/15 0 1,15 * 1-5 /usr/bin/find"],
                []
        ]
    }
}
