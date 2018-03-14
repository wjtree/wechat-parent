package com.app.wechat.request;

import com.app.wechat.domain.WxCustomSendModel;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxCustomSendResponse;

/**
 * <p>功 能：发送客服消息API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 * <br/>
 * <p>当用户和公众号产生特定动作的交互时（具体动作列表请见下方说明），微信将会把消息数据推送给开发者，开发者可以在一段时间内（目前修改为48小时）调用客服接口，通过POST一个JSON数据包来发送消息给普通用户。<br/>
 * 此接口主要用于客服等有人工消息处理环节的功能，方便开发者为用户提供更加优质的服务。</p>
 * <br/>
 * <p>注意：目前允许的动作列表如下(即触发客服消息接口)</p>
 * <ol>
 * <li>用户发送信息</li>
 * <li>点击自定义菜单（仅有点击推事件、扫码推事件、扫码推事件且弹出“消息接收中”提示框这3种菜单类型是会触发客服接口的）</li>
 * <li>关注公众号</li>
 * <li>扫描二维码</li>
 * <li>支付成功</li>
 * <li>用户维权</li>
 * </ol>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCustomSendRequest extends AbstractWxRequest<WxCustomSendResponse> {
    private static final long serialVersionUID = 1L;

    private WxCustomSendModel object;

    public WxCustomSendRequest(WxCustomSendModel object) {
        this.object = object;
    }

    public WxCustomSendModel getObject() {
        return object;
    }

    public Class<WxCustomSendResponse> getResponseClass() {
        return WxCustomSendResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MESSAGE_CUSTOM_SEND, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}