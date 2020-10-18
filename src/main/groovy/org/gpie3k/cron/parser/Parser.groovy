package org.gpie3k.cron.parser

class Parser {

    static Result parse(String input) {
        def res = new Result()

        def strings = input.split(' ')

        res.getClass().getDeclaredFields().findAll(Output.&isField).eachWithIndex { it, i ->
            def data = it.getAnnotation(FieldData)
            res[it.name] = data.parser().getDeclaredConstructor().newInstance().parse(data, strings[i])
        }

        res
    }
}
