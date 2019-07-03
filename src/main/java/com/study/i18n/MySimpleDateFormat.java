package com.study.i18n;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 华志宾
 * @date 2019-05-08
 */
public class MySimpleDateFormat {
    /**
     * 编号  字母  描述
     *
     * 1  G  用于显示时代。
     *
     *
     * 2
     * y
     * 显示年份。 有效值为:yy，yyyy。
     *
     *
     * 3
     * M
     * 显示月份。 有效值为:MM，MMM或MMMMM。
     *
     *
     * 4
     * d
     * 显示月份中的第几天。 有效值为:d，dd。
     *
     *
     * 5
     * h
     * 显示一天中的小时(1-12 AM/PM)。 有效值为:hh。
     *
     *
     * 6
     * H
     * 显示一天中的小时(0-23)。 有效值为:HH。
     *
     *
     * 7
     * m
     * 显示分钟(0-59)。 有效值为:mm。
     *
     *
     * 8
     * s
     * 显示秒钟(0-59)。 有效值为:ss。
     *
     *
     * 9
     * S
     * 显示毫秒(0-999)。 有效值为:SSS。
     *
     *
     * 10
     * E
     * 显示星期几(例如:星期一，星期二等)
     *
     *
     * 11
     * D
     * 显示每年的日期(1-366)。
     *
     *
     * 12
     * F
     * 显示月份中的星期几(例如12月的第一个星期四)。
     *
     *
     * 13
     * w
     * 显示每年的周(1-53)。
     *
     *
     * 14
     * W
     * 显示月份中的星期(0-5)
     *
     *
     * 15
     * a
     * 显示为:AM或PM
     *
     *
     * 16
     * k
     * 在一天中显示小时(1-24)。
     *
     *
     * 17
     * K
     * 要显示小时，AM / PM(0-11)。
     *
     *
     * 18
     * z
     * 显示时区。
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {

        String pattern = "dd-MM-yy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));

        pattern = "MM-dd-yyyy";
        simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(date));

        pattern = "yyyy-MM-dd HH:mm:ss";
        simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(date));

        pattern = "EEEEE MMMMM yyyy HH:mm:ss.SSSZ";
        simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(date));
    }

}
