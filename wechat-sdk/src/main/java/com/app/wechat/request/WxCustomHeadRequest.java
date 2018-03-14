package com.app.wechat.request;

import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxCustomHeadResponse;

/**
 * <p>功 能：客服帐号管理-设置客服帐号的头像API的请求信息</p>
 * <p>描 述：开发者可以通过本接口为公众号添加客服账号，每个公众号最多添加10个客服账号</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCustomHeadRequest extends AbstractWxRequest<WxCustomHeadResponse> {
    private static final long serialVersionUID = 1L;

    /**
     * 客服账号
     */
    private String kfAccount;

    /**
     * 待上传的客服头像图片的全路径名称
     */
    private String imgPath;

    /**
     * @param kfAccount 客服账号
     * @param imgPath   待上传的客服头像图片的全路径名称
     */
    public WxCustomHeadRequest(String kfAccount, String imgPath) {
        this.kfAccount = kfAccount;
        this.imgPath = imgPath;
    }

    public String getObject() {
        return imgPath;
    }

    public Class<WxCustomHeadResponse> getResponseClass() {
        return WxCustomHeadResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_CUSTOMSERVICE_KFACCOUNT_UPLOADHEADIMG, accessToken, kfAccount);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST_FORM;
    }
}