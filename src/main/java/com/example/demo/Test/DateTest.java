package com.example.demo.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class DateTest {
    public static void main(String[] args) {
        //获取当前年月日
        LocalDate localDate = LocalDate.now();
         //构造指定的年月日
        LocalDate localDate1 = LocalDate.of(2019, 9, 10);
        System.out.println("年月日："  +  localDate);
        System.out.println("年月日："  +  localDate1);
        int year = localDate.getYear();
        int year1 = localDate.get(ChronoField.YEAR);
        Month month = localDate.getMonth();
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.getDayOfMonth();
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);
        System.out.println("年："  +  year);
        System.out.println("年："  +  year1);
        System.out.println("月："  +  month);
        System.out.println("月："  +  month1);
        System.out.println("日："  +  day);
        System.out.println("日："  +  day1);
    }
}
