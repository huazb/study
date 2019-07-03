package com.study.i18n;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * UTC代表协调世界时。 这是时间标准，并在全世界普遍使用。
 * 所有时区的计算都与UTC的时差相当。
 * 例如，丹麦哥本哈根的时间是UTC + 1表示UTC时间加上一个小时。用于在数据库中存储日期和时间。
 *
 *
 * @author 华志宾
 * @date 2019-05-08
 */
public class UTC {
    public static void main(String[] args) throws ParseException {


        String[] availableIDs = TimeZone.getAvailableIDs();

        for(String id : availableIDs) {
            System.out.println("Timezone = " + id);
        }

        System.out.println("\nTimeZone:\n");

        Calendar date = new GregorianCalendar();

        date.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        date.set(Calendar.HOUR_OF_DAY, 12);

        System.out.println("UTC: " + date.get(Calendar.HOUR_OF_DAY));
        System.out.println("UTC: " + date.getTimeInMillis());

        date.setTimeZone(TimeZone.getTimeZone("Europe/Copenhagen"));
        System.out.println("CPH: " + date.get(Calendar.HOUR_OF_DAY));
        System.out.println("CPH: " + date.getTimeInMillis());

        date.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println("NYC: " + date.get(Calendar.HOUR_OF_DAY));
        System.out.println("NYC: " + date.getTimeInMillis());
    }
}
