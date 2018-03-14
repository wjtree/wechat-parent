/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.request;

import com.app.wechat.domain.mass.WxMassModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.internal.util.WxMassUtil;
import com.app.wechat.response.WxMassDelResponse;

/**
 * <p>功 能：群发消息-删除群发API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 * <br/>
 * <p>请注意：</p>
 * <ol>
 * <li>只有已经发送成功的消息才能删除</li>
 * <li>删除消息是将消息的图文详情页失效，已经收到的用户，还是能在其本地看到消息卡片</li>
 * <li>删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除</li>
 * <li>如果多次群发发送的是一个图文消息，那么删除其中一次群发，就会删除掉这个图文消息，导致所有群发都失效</li>
 * </ol>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMassDelRequest extends AbstractWxRequest<WxMassDelResponse> {
    private static final long serialVersionUID = 1L;

    private WxMassModel object;

    /**
     * @param msgId 发送出去的消息ID
     */
    public WxMassDelRequest(Long msgId) {
        this(msgId, null);
    }

    /**
     * @param msgId      发送出去的消息ID
     * @param articleIdx 要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章
     */
    public WxMassDelRequest(Long msgId, Short articleIdx) {
        this.object = WxMassUtil.getWxMassModel(msgId, articleIdx);
    }

    public WxMassModel getObject() {
        return object;
    }

    public Class<WxMassDelResponse> getResponseClass() {
        return WxMassDelResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MESSAGE_MASS_DELETE, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}