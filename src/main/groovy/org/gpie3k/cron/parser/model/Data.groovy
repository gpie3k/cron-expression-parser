package org.gpie3k.cron.parser.model

import org.gpie3k.cron.parser.field.FieldParser
import org.gpie3k.cron.parser.field.NumberFieldParser

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Data {
    String text()

    int min() default 0

    int max() default 0

    Class<? extends FieldParser> parser() default NumberFieldParser
}