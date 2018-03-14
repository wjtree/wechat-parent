package com.app.wechat.response;

/**
 * <p>功 能：群发消息-上传图文消息内的图片获取URL API的响应结果</p>
 * <p>描 述：本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:54:14</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMediaUploadImgResponse extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 上传图片的URL
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}