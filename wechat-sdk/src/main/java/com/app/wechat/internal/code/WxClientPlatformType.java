package com.app.wechat.internal.code;

/**
 * <p>功 能：微信公众号语言信息枚举</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午4:15:17</p>
 *
 * @author 王建
 * @version 1.0
 */
public enum WxClientPlatformType {
    /**
     * IOS
     */
    IOS("1", "IOS"), /**
     * Android
     */
    ANDROID("2", "Android"), /**
     * Others
     */
    OTHERS("3", "Others");

    private String code;

    private String msg;

    private WxClientPlatformType(String code, String msg) {
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