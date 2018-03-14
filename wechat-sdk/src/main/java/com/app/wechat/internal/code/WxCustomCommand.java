package com.app.wechat.internal.code;

/**
 * 微信公众平台客服输入状态枚举
 *
 * @author Administrator
 * @version 1.0
 */
public enum WxCustomCommand {
    TYPING("Typing"), CANCELTYPING("CancelTyping");

    private String code;

    WxCustomCommand(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}