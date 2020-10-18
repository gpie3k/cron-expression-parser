package org.gpie3k.cron.parser

import org.gpie3k.cron.parser.model.Data
import org.gpie3k.cron.parser.model.Result
import org.gpie3k.cron.parser.output.Output

class Parser {

    static Result parse(String input) {
        def res = new Result()

        def strings = input.split(' ')

        res.getClass().getDeclaredFields().findAll(Output.&isField).eachWithIndex { it, i ->
            def data = it.getAnnotation(Data)
            res[it.name] = data.parser().getDeclaredConstructor().newInstance().parse(data, strings[i])
        }

        res
    }
}
