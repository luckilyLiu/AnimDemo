package com.gengmei.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by liukunyu on 2021/1/20 16:39.
 * desc: 动态代理类
 */
public class DynamicProxy implements InvocationHandler {
    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("开始：" + method.getName());
        method.invoke(object, objects);
        System.out.println("结束：" + method.getName());
        return null;
    }
}
