package com.example;

public class EvenNoChecker {
    public boolean isEven(int n)
    {
        return n%2==0;

    }

    public boolean checkLength(String name)
    {
        return name.length()>2;

    }

    public boolean isWeekDay(WeekDays wd)
    {
        return wd==WeekDays.SUNDAY;
    }

    public int  factorial(int n)
    {
        int fact = 1;
        for (int i = 1; i <= n; i++)
        {
            fact *= i;
        }
        return fact;
    }
}
