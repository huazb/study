package com.study.proxy.createobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 华志宾
 * @date 2019-03-26
 */
public class ObjectPoolFactory {
    private Map<String, Object> map = new HashMap<String, Object>();

    /** 创建对象 */
    private Object createObject(String className)
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        Class<?> claxx = Class.forName(className);
        return claxx.newInstance();
    }

    /** 初始化对象池*/
    public void initPool(String fileName) throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            Properties p = new Properties();
            p.load(fis);
            for (String name : p.stringPropertyNames()) {
                map.put(name, p.getProperty(name));
            }
        } catch (Exception e) {
            System.out.println("读取" + fileName + "异常");
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    /** 从对象池中取出指定name对应的对象 */
    public Object getObject(String name) {
        return map.get(name);
    }

    public static void main(String[] args) throws IOException {
        ObjectPoolFactory pool=new ObjectPoolFactory();
        pool.initPool("obj.text");
        pool.getObject("a");
    }
}
