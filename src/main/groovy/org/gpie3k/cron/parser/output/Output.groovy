package org.gpie3k.cron.parser.output

import org.gpie3k.cron.parser.model.Data
import org.gpie3k.cron.parser.model.Result

import java.lang.reflect.Field

class Output {
    static final COL_WIDTH = 14

    static String format(Result result) {
        result.getClass().getDeclaredFields().findAll(Output.&isField).collect(Output.&format.curry(result)).join('\n')
    }

    static boolean isField(Field field) {
        field.getAnnotation(Data) != null
    }

    static String format(Result result, Field it) {
        def field = it.getAnnotation(Data)
        def value = Arrays.asList(result[it.name])

        field.text().padRight(COL_WIDTH) + value.join(' ')
    }
}
