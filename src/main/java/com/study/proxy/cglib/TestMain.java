package com.study.proxy.cglib;

import com.study.proxy.UserService;
import com.study.proxy.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author 华志宾
 * @date 2019-03-26
 */
public class TestMain {
    /**
     *Cglib是一个优秀的动态代理框架，它的底层使用ASM在内存中动态的生成被代理类的子类，使用CGLIB即使代理类没有实现任何接口也可以实现动态代理功能。
     * CGLIB具有简单易用，它的运行速度要远远快于JDK的Proxy动态代理：
     *
     * CGLIB的核心类：
     *     net.sf.cglib.proxy.Enhancer – 主要的增强类
     *     net.sf.cglib.proxy.MethodInterceptor – 主要的方法拦截类，它是Callback接口的子接口，需要用户实现
     *     net.sf.cglib.proxy.MethodProxy – JDK的java.lang.reflect.Method类的代理类，可以方便的实现对源对象方法的调用,如使用：
     *     Object o = methodProxy.invokeSuper(proxy, args);//虽然第一个参数是被代理对象，也不会出现死循环的问题。
     *
     * net.sf.cglib.proxy.MethodInterceptor接口是最通用的回调（callback）类型，它经常被基于代理的AOP用来实现拦截（intercept）方法的调用。
     * 这个接口只定义了一个方法
     * public Object intercept(Object object, java.lang.reflect.Method method,
     * Object[] args, MethodProxy proxy) throws Throwable;
     *
     * 第一个参数是代理对像，第二和第三个参数分别是拦截的方法和方法的参数。
     * 原来的方法可能通过使用java.lang.reflect.Method对象的一般反射调用，
     * 或者使用 net.sf.cglib.proxy.MethodProxy对象调用。
     * net.sf.cglib.proxy.MethodProxy通常被首选使用，因为它更快。
     */
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService o = (UserService)enhancer.create();
        o.getName(1);
        o.getAge(1);
    }
}
