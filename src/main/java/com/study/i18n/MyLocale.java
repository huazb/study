package com.study.i18n;

import java.util.Locale;

/**
 * @author 华志宾
 * @date 2019-05-08
 */
public class MyLocale {
    public static void main(String[] args) {
        Locale locale =Locale.getDefault();

        System.out.println("Default Locale Properties:\n");

        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayName());
        System.out.println(locale.getISO3Country());
        System.out.println(locale.getISO3Language());
        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());

        Locale frenchLocale = new Locale("fr","fr");

        System.out.println("\nfr Locale Properties:\n");
        System.out.println(frenchLocale.getDisplayCountry());
        System.out.println(frenchLocale.getDisplayLanguage());
        System.out.println(frenchLocale.getDisplayName());
        System.out.println(frenchLocale.getISO3Country());
        System.out.println(frenchLocale.getISO3Language());
        System.out.println(frenchLocale.getLanguage());
        System.out.println(frenchLocale.getCountry());


        System.out.println("\n国际化(i18n)显示语言:\n");
        Locale defaultLocale = Locale.getDefault();
        Locale enLocale = new Locale("en", "US");
        Locale frLocale = new Locale("fr", "FR");
        Locale esLocale = new Locale("es", "ES");

        System.out.println(defaultLocale.getDisplayLanguage(enLocale));
        System.out.println(defaultLocale.getDisplayLanguage(frLocale));
        System.out.println(defaultLocale.getDisplayLanguage(esLocale));
    }
}
