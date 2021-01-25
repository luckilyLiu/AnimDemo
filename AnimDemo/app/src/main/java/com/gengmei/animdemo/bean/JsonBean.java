package com.gengmei.animdemo.bean;

import java.util.List;

import static com.gengmei.animdemo.activity.MultiTypeActivity.TYPE_0;
import static com.gengmei.animdemo.activity.MultiTypeActivity.TYPE_1;
import static com.gengmei.animdemo.activity.MultiTypeActivity.TYPE_2;

public class JsonBean {

    public List<SubTabBean> subTab;
    public List<SignListBean> signList;

    public static class DataBean{
        public String datatype;

    }

    public static class SubTabBean  extends CardBean {
        public String tagName;
        public String tagid;
        public String tagType;
        public String tagExtendParam;
        @Override
        public int getCardType() {
            int type;
            switch (tagType) {
                case "0":
                    type = TYPE_0;
                    break;
                case "1":
                    type = TYPE_1;
                    break;
                case "2":
                    type = TYPE_2;
                    break;
                default:
                    type = -1;
                    break;
            }
            return type;
        }

        @Override
        public String getUniqueId() {
            return null;
        }
    }

    public static class SignListBean  extends CardBean {
        public String tagName;
        public String tagid;
        public String tagType;
        public String tagExtendParam;
        @Override
        public int getCardType() {
            int type;
            switch (tagType) {
                case "0":
                    type = TYPE_0;
                    break;
                case "1":
                    type = TYPE_1;
                    break;
                case "2":
                    type = TYPE_2;
                    break;
                default:
                    type = -1;
                    break;
            }
            return type;
        }

        @Override
        public String getUniqueId() {
            return null;
        }
    }
}
