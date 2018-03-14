package com.app.wechat.internal.code;

/**
 * <p>功 能：微信公众号模板消息发送状态枚举</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午4:15:17</p>
 *
 * @author 王建
 * @version 1.0
 */
public enum WxTmplSendStatus {
    /**
     * 发送成功
     */
    SUCCESS("0", "success"), /**
     * 由于用户拒收失败
     */
    FAIL_BLOCK("1", "failed:user block"), /**
     * 由于其他原因失败
     */
    FAIL_SYSTEM("2", "failed:system failed");

    /**
     * 状态码
     */
    private String code;

    /**
     * 状态消息
     */
    private String msg;

    private WxTmplSendStatus(String code, String msg) {
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