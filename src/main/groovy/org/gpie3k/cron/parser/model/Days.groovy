package org.gpie3k.cron.parser.model

enum DAYS {
    MON(1), TUE(2), WED(3), THR(4), FRI(5), SAT(6), SUN(7);

    DAYS(int val) {
        value = val
    }

    int value
}