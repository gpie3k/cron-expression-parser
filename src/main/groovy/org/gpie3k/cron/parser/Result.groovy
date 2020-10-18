package org.gpie3k.cron.parser

import groovy.transform.Canonical

@Canonical
class Result {
    @FieldData(text = 'minute       ', min = 0, max = 59) int[] minute
    @FieldData(text = 'hour         ', min = 0, max = 23) int[] hour
    @FieldData(text = 'day of month ', min = 0, max = 31) int[] day
    @FieldData(text = 'month        ', min = 1, max = 12) int[] month
    @FieldData(text = 'day of week  ', min = 1, max = 7) int[] dayOfWeek
    @FieldData(text = 'command      ', parser = TextFieldParser) String command
}
