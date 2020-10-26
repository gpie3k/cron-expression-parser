package org.gpie3k.cron.parser.model

import groovy.transform.Canonical
import org.gpie3k.cron.parser.field.DayOfWeekFieldParser
import org.gpie3k.cron.parser.field.TextFieldParser

@Canonical
class Result {
    @Data(text = 'minute', min = 0, max = 59)
    int[] minute
    @Data(text = 'hour', min = 0, max = 23)
    int[] hour
    @Data(text = 'day of month', min = 1, max = 31)
    int[] day
    @Data(text = 'month', min = 1, max = 12)
    int[] month
    @Data(text = 'day of week', min = 1, max = 7, parser = DayOfWeekFieldParser)
    int[] dayOfWeek
    @Data(text = 'command', parser = TextFieldParser)
    String command
}
