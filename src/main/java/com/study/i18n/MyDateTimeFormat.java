package com.study.i18n;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author 华志宾
 * @date 2019-05-08
 */
public class MyDateTimeFormat {
    public static void main(String[] args) {

        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);

        System.out.println(dateFormat.format(new Date()));

    }
}
