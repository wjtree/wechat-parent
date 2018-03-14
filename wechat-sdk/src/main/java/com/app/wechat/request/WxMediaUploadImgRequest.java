package com.app.wechat.request;

import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxMediaUploadImgResponse;

/**
 * <p>功 能：上传图文消息内的图片获取URL API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 * <br/>
 * <p>请注意：</p>
 * <ol>
 * <li>本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制</li>
 * <li>图片仅支持jpg/png格式，大小必须在1MB以下</li>
 * </ol>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMediaUploadImgRequest extends AbstractWxRequest<WxMediaUploadImgResponse> {
    private static final long serialVersionUID = 1L;

    /**
     * 待上传图片的全路径名称
     */
    private String imgPath;

    /**
     * @param imgPath 待上传图片的全路径名称
     */
    public WxMediaUploadImgRequest(String imgPath) {
        this.imgPath = imgPath;
    }

    public Object getObject() {
        return imgPath;
    }

    public Class<WxMediaUploadImgResponse> getResponseClass() {
        return WxMediaUploadImgResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MEDIA_UPLOADIMG, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST_FORM;
    }
}