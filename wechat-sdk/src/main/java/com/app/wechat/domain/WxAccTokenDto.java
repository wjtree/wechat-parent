package com.app.wechat.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.response.AbstractWxResponse;

/**
 * <p>功 能：微信服务器获取接口调用凭证API的响应结果</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月30日 下午5:43:51</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxAccTokenDto extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 接口调用凭据
     */
    @JSONField(name = "access_token")
    private String accessToken;

    /**
     * 凭据有效时间，单位：秒
     */
    @JSONField(name = "expires_in")
    private Integer expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}