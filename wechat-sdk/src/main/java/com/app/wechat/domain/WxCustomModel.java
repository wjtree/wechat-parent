package com.app.wechat.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>功 能：客服帐号API参数</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月10日 下午5:30:32</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCustomModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 完整客服账号，格式为：账号前缀@公众号微信号
     */
    @JSONField(name = "kf_account")
    private String kfAccount;

    /**
     * 客服昵称
     */
    @JSONField(name = "kf_nick")
    private String kfNick;

    /**
     * 客服工号
     */
    @JSONField(name = "kf_id")
    private String kfId;

    /**
     * 客服头像的图片链接
     */
    @JSONField(name = "kf_headimgurl")
    private String kfHeadImgUrl;

    /**
     * 客服昵称，最长6个汉字或12个英文字符
     */
    private String nickname;

    /**
     * 客服账号登录密码，格式为密码明文的32位加密MD5值。<br/>
     * 该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
     */
    private String password;

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public String getKfNick() {
        return kfNick;
    }

    public void setKfNick(String kfNick) {
        this.kfNick = kfNick;
    }

    public String getKfId() {
        return kfId;
    }

    public void setKfId(String kfId) {
        this.kfId = kfId;
    }

    public String getKfHeadImgUrl() {
        return kfHeadImgUrl;
    }

    public void setKfHeadImgUrl(String kfHeadImgUrl) {
        this.kfHeadImgUrl = kfHeadImgUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}