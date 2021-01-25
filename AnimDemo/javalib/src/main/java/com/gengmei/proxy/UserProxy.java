package com.gengmei.proxy;

/**
 * Created by liukunyu on 2021/1/20 15:16.
 * desc:
 */
public class UserProxy implements IUser{
    private IUser iUser;

    public UserProxy(IUser iUser) {
        this.iUser = iUser;
    }

    @Override
    public void save() {
        System.out.println("开始");
        iUser.save();
        System.out.println("结束\n\t");
    }
}
