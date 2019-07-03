package com.study.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 华志宾
 * @date 2019-03-26
 */
public class MethodInvoke {
    /**
     * 一般情况下，我们并不能对类的私有字段进行操作，利用反射也不例外，
     * 但有的时候，例如要序列化的时候，我们又必须有能力去处理这些字段，
     * 这时候，我们就需要调用AccessibleObject上的setAccessible()方法来允许这种访问，
     * 而由于反射类中的Field，Method和Constructor继承自AccessibleObject，
     * 因此，通过在这些类上调用setAccessible()方法，我们可以实现对这些字段的操作。
     * 但有的时候这将会成为一个安全隐患，为此，
     * 我们可以启用Java.security.manager来判断程序是否具有调用setAccessible()的权限。
     * 默认情况下，内核API和扩展目录的代码具有该权限，
     * 而类路径或通过URLClassLoader加载的应用程序不拥有此权限。
     *
     * 方法的调用，其使用的构造方法必须是public，不能是其他类型
     *
     * setAccessbile方法属于AccessibleObject，不属于Method
     * 是通过反射来访问private方法、private构造器、private属性。
     * java.lang.reflect
     * 类 AccessibleObject
     * java.lang.Object
     * java.lang.reflect.AccessibleObject
     * 所有已实现的接口：
     * AnnotatedElement
     * 直接已知子类：
     * Constructor, Field, Method
     */
    public static void main(String[] args) throws NoSuchMethodException,
            SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException,
            InstantiationException {
        Class c = Test.class;
        Object obj = c.newInstance();
        Method m = c.getDeclaredMethod("setName", String.class);
        /* 指示该Method在使用时，取消java语言访问权限检查 */
        m.setAccessible(true);
        m.invoke(obj, "张三");
    }
}

class Test {
    private String name;

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
        System.out.println(this.getName());
    }
}
