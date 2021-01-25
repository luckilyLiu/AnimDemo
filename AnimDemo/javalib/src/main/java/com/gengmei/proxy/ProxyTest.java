package com.gengmei.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by liukunyu on 2021/1/20 15:15.
 * desc:
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 静态代理
        UserProxy userProxy = new UserProxy(new User());
        userProxy.save();

        // 动态代理
        User user = new User();
        DynamicProxy dynamicProxy = new DynamicProxy(user);
        IUser iUserProxy = (IUser) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), dynamicProxy);
        iUserProxy.save();
    }
}
