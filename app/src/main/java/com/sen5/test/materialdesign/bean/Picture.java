package com.sen5.test.materialdesign.bean;

/**
 * Created by chenqianghua on 2017/3/17.
 */

public class Picture {
    int resouceId;
    String discription;

    public Picture(int resouceId, String discription) {
        this.resouceId = resouceId;
        this.discription = discription;
    }

    public int getResouceId() {
        return resouceId;
    }

    public void setResouceId(int resouceId) {
        this.resouceId = resouceId;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
