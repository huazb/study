package com.study.java8.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 华志宾
 * @date 2019-05-13
 */
public class IterMap {

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("111", "222");
        Set<Map.Entry<String, String>> entrySet = hm.entrySet();
        Iterator<Map.Entry<String, String>> iter = entrySet.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
