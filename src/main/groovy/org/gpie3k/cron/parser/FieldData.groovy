package org.gpie3k.cron.parser

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldData {
    String text()
    int min() default 0
    int max() default 0
    Class<? extends FieldParser> parser() default NumberFieldParser
}