package com.gengmei.animdemo.bean;

import static com.gengmei.animdemo.activity.MultiTypeActivity.TYPE_1;

public class Card1Bean extends CardBean {

    @Override
    public int getCardType() {
        return TYPE_1;
    }

    @Override
    public String getUniqueId() {
        return null;
    }
}
