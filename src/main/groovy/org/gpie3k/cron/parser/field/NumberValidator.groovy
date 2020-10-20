package org.gpie3k.cron.parser.field

import org.gpie3k.cron.parser.model.Data

class NumberValidator {
    static validate(Data data, int input) {
        input in data.min()..data.max() || invalidInput(input)
    }

    static boolean invalidInput(int input) {
        throw new RuntimeException("Invalid input: ${input}")
    }
}
