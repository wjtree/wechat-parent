package com.app.wechat.internal.code;

/**
 * <p>功 能：微信公众号性别枚举</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午4:15:17</p>
 *
 * @author 王建
 * @version 1.0
 */
public enum WxSex {
    /**
     * 男
     */
    MALE("1", "男"), /**
     * 女
     */
    FEMALE("2", "女");


    /**
     * 性别标识
     */
    private String sex;

    /**
     * 性别说明
     */
    private String remark;

    private WxSex(String sex, String remark) {
        this.sex = sex;
        this.remark = remark;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}