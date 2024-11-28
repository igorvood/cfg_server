package ru.vtb.processor.annotation


interface F1

interface F2: F1

interface F3: F2


interface MyTwoGeneric<IN, OUT>:F3, F1


interface MyOneGeneric<IN>: MyTwoGeneric<IN, String>

