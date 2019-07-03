package com.study.java8.lambda;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 华志宾
 * @date 2019-06-17
 */
public class MainTest {
    // command + j , psvm
    public static void main(String[] args) throws Exception {
        Arrays.asList("a","b").forEach(e -> System.out.println(e));

        DateFormat format = DateFormat.getDateTimeInstance();
        System.out.printf(format.parse("2019-6-27 18:13:44").toString());
    }
}
