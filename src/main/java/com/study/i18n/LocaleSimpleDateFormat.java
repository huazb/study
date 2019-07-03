package com.study.i18n;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author 华志宾
 * @date 2019-05-08
 */
public class LocaleSimpleDateFormat {
    public static void main(String[] args) throws ParseException {

        Locale locale = new Locale("da", "DK");
        String pattern = "EEEEE MMMMM yyyy";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = new Date();

        System.out.println(date);
        System.out.println(simpleDateFormat.format(date));

        simpleDateFormat = new SimpleDateFormat(pattern,locale);

        System.out.println(simpleDateFormat.format(date));
    }

}
