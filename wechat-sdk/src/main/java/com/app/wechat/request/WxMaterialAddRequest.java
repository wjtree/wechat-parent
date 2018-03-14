package com.app.wechat.request;

import com.app.wechat.domain.WxUploadModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxMediaType;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.internal.util.WxUploadUtil;
import com.app.wechat.response.WxMaterialAddResponse;

import java.util.Map;

/**
 * <p>功 能：新增其他类型永久素材API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 * <br/>
 * <p>请注意：</p>
 * <ol>
 * <li>公众号的素材库保存总数量有上限：图文消息素材、图片素材上限为5000，其他类型为1000</li>
 * <li>永久图片素材新增后，将带有URL返回给开发者，开发者可以在腾讯系域名内使用（腾讯系域名外使用，图片将被屏蔽）</li>
 * <li>图片素材将进入公众平台官网素材管理模块中的默认分组</li>
 * <li>通过POST表单来调用接口，表单id为media，包含需要上传的素材内容，有filename、filelength、content-type等信息</li>
 * <li>上传视频素材时需要POST另一个表单，id为description，包含素材的描述信息，内容格式为JSON</li>
 * </ol>
 * <p>素材的格式大小等要求与公众平台官网一致：</p>
 * <ol>
 * <li>图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式</li>
 * <li>语音（voice）：2M，播放长度不超过60s，mp3/wma/wav/amr格式</li>
 * <li>视频（video）：10MB，支持MP4格式</li>
 * <li>缩略图（thumb）：64KB，支持JPG格式</li>
 * </ol>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMaterialAddRequest extends AbstractWxRequest<WxMaterialAddResponse> {
    private static final long serialVersionUID = 1L;

    /**
     * 模拟表单form-data媒体文件标识对象
     */
    private WxUploadModel object;

    /**
     * 媒体文件类型
     */
    private WxMediaType mediaType;

    /**
     * @param pathName  待上传文件路径
     * @param mediaType 媒体文件类型
     */
    public WxMaterialAddRequest(String pathName, WxMediaType mediaType) {
        this(pathName, mediaType, null, null);
    }

    /**
     * @param pathName     待上传文件路径
     * @param mediaType    媒体文件类型
     * @param title        视频素材的标题
     * @param introduction 视频素材的描述
     */
    public WxMaterialAddRequest(String pathName, WxMediaType mediaType, String title, String introduction) {
        // 新增永久视频素材需另外上传ID为“description”的表单
        Map<String, Object> formData = WxMediaType.VIDEO.equals(mediaType) ? WxUploadUtil.getVideoFormData(title, introduction) : null;
        // 属性绑定
        this.object = WxUploadUtil.getWxFormDataModel(pathName, formData);
        this.mediaType = mediaType;
    }

    public Object getObject() {
        return object;
    }

    public Class<WxMaterialAddResponse> getResponseClass() {
        return WxMaterialAddResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MATERIAL_ADD_MATERIAL, accessToken, mediaType.name().toLowerCase());
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST_FORM;
    }
}