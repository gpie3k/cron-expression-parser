package org.gpie3k.cron.parser

import java.lang.reflect.Field

class Output {
    String format(Result result) {
        result.getClass().getDeclaredFields().findAll(Output.&isField).collect(Output.&format.curry(result)).join('\n')
    }

    static boolean isField(Field field) {
        field.getAnnotation(FieldData) != null
    }

    static String format(Result result, Field it) {
        def field = it.getAnnotation(FieldData)
        def value = Arrays.asList(result[it.name])

        "${field.text()} ${value.join(' ')}"
    }
}
