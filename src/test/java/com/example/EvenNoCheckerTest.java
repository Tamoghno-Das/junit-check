package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EvenNoCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 })

    void isEvenChecker(int num) {
        EvenNoChecker e = new EvenNoChecker();
//        assertTrue(e.isEven(2));
//        assertTrue(e.isEven(3));
//        assertTrue(e.isEven(4));
//        assertTrue(e.isEven(5));
//        assertTrue(e.isEven(6));
//        assertTrue(e.isEven(7));
//        assertTrue(e.isEven(8));
//        assertTrue(e.isEven(9));
//        assertTrue(e.isEven(10));
        assertTrue(e.isEven(num));

    }
    @ParameterizedTest
    @ValueSource(strings = { "Amitava","Tamoghno","Trisha","Ru" })

    void isNameGtTwo(String name)
    {
        EvenNoChecker e = new EvenNoChecker();
        assertTrue(e.checkLength(name));
    }

    @ParameterizedTest
    @EnumSource(value = WeekDays.class,names = {"MONDAY","TUESDAY","WEDNESDAY","SUNDAY"})
    void checkWeekDay(WeekDays wd)
    {
        assertTrue(new EvenNoChecker().isWeekDay(wd));
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "0, 1",
                    "1, 1",
                    "2, 2",
                    "3, 6",
                    "4, 24",
                    "5, 120",
                    "6, 520"
            }
    )
    void factorialCheck(int no, int expected)
    {
        assertEquals(expected, new EvenNoChecker().factorial(no));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/tom/data.csv")
    void factorialCheck_external(int no, int expected)
    {
        assertEquals(expected, new EvenNoChecker().factorial(no));
    }



}