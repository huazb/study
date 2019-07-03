package com.study.i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author 华志宾
 * @date 2019-05-08
 */
public class MyDateFormat {
    public static void main(String[] args) {
        Locale locale = new Locale("da","DK");

        DateFormat dateFormat = DateFormat.getDateInstance();

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        System.out.println(dateFormat.format(new Date()));


        DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.DEFAULT);

        System.out.println(dateFormat2.format(new Date()));

        dateFormat2 = DateFormat.getDateInstance(DateFormat.SHORT);

        System.out.println(dateFormat2.format(new Date()));

        dateFormat2 = DateFormat.getDateInstance(DateFormat.MEDIUM);

        System.out.println(dateFormat2.format(new Date()));

        dateFormat2 = DateFormat.getDateInstance(DateFormat.LONG);

        System.out.println(dateFormat2.format(new Date()));

        dateFormat2 = DateFormat.getDateInstance(DateFormat.FULL);

        System.out.println(dateFormat2.format(new Date()));

        System.out.println("\ntimeFormat:\n");

        DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT);

        System.out.println(timeFormat.format(new Date()));

        timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT);

        System.out.println(timeFormat.format(new Date()));

        timeFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM);

        System.out.println(timeFormat.format(new Date()));

        timeFormat = DateFormat.getTimeInstance(DateFormat.LONG);

        System.out.println(timeFormat.format(new Date()));

        timeFormat = DateFormat.getTimeInstance(DateFormat.FULL);

        System.out.println(timeFormat.format(new Date()));
    }
}
