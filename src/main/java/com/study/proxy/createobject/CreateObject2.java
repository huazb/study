package com.study.proxy.createobject;

import java.lang.reflect.Constructor;

/**
 * @author 华志宾
 * @date 2019-03-26
 */
public class CreateObject2 {
    public static void main(String[] args) throws Exception {
        Class c = Test2.class;
        Constructor con = c.getDeclaredConstructor(String.class);
        Object newInstance = con.newInstance("zhangsan");
        System.out.println(newInstance);
    }

}

class Test2 {
    private String name;
    private int age;
    String sex;

    private Test2() {

    }

    protected Test2(String name) {
        super();
        this.name = name;
    }

    public Test2(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Test2(String name, int age, String sex) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Test2 [name=" + name + ", age=" + age + ", sex=" + sex + "]";
    }
}
