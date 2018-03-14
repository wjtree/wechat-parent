package com.app.wechat.internal.code;

/**
 * <p>功 能：微信公众号群发状态枚举</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午4:15:17</p>
 *
 * @author 王建
 * @version 1.0
 */
public enum WxMsSendCheckState {
    /**
     * 未被判为转载，可以群发
     */
    STATE1("1", "未被判为转载，可以群发"), /**
     * 被判为转载，可以群发
     */
    STATE2("2", "被判为转载，可以群发"), /**
     * 被判为转载，不能群发
     */
    STATE3("3", "被判为转载，不能群发");

    /**
     * 状态码
     */
    private String code;

    /**
     * 状态消息
     */
    private String msg;

    private WxMsSendCheckState(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}