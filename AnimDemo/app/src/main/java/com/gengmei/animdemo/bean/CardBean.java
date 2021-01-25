package com.gengmei.animdemo.bean;

import java.io.Serializable;

/**
 * <p>***********************************************************************
 * <p> Author: liukunyu
 * <p> CreateData: 2020-11-18 14:45
 * <p> Description: 卡片基类bean
 * <p>
 * <p>***********************************************************************
 */

public abstract class CardBean implements Serializable {

    /**
     * 卡片类型
     *
     * @return int
     */
    public abstract int getCardType();

    /**
     * 去重id
     *
     * @return String
     */
    public abstract String getUniqueId();
}
