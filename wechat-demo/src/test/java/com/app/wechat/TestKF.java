package com.app.wechat;

import com.app.wechat.code.WxConstant;
import com.app.wechat.core.DefaultWxClient;
import com.app.wechat.core.WxClient;
import com.app.wechat.domain.WxCustomModel;
import com.app.wechat.domain.WxCustomSendModel;
import com.app.wechat.internal.code.WxCustomCommand;
import com.app.wechat.internal.util.WxCustomUtil;
import com.app.wechat.request.WxCustomGetRequest;
import com.app.wechat.request.WxCustomSendRequest;
import com.app.wechat.request.WxCustomTypingRequest;
import org.junit.Test;

public class TestKF {
    WxClient client = new DefaultWxClient(WxConstant.APP_ID, WxConstant.APP_SECRET);

    @Test
    public void test() throws Exception {
        WxCustomModel model = WxCustomUtil.getWxCustomModel("kf001", "冰冰", "123123");

        // WxCustomAddRequest request = new WxCustomAddRequest(model);
        // WxCustomUpdateRequest request = new WxCustomUpdateRequest(model);
        // WxCustomDelRequest request = new WxCustomDelRequest(model);
        // WxCustomHeadRequest request = new WxCustomHeadRequest("kf001", "E:\\WorkSpace\\Resouce\\head.jpg");
        WxCustomGetRequest request = new WxCustomGetRequest();

        client.execute(request);
    }

    @Test
    public void command() throws Exception {
        WxCustomSendModel model = WxCustomUtil.getWxCustomSendModel("oX_DYt3AiupzsygSGIcqzw-l6NNo", WxCustomCommand.CANCELTYPING);

        WxCustomTypingRequest request = new WxCustomTypingRequest(model);

        client.execute(request);
    }

    @Test
    public void send() throws Exception {
        // WxCustomSendModel model = WxCustomUtil.getTextMsg("oX_DYt3AiupzsygSGIcqzw-l6NNo", "客服文本消息", "test1@kftest");
        // WxCustomSendModel model = WxCustomUtil.getTextMsg("oX_DYt3AiupzsygSGIcqzw-l6NNo", "客服文本消息");
        WxCustomSendModel model = WxCustomUtil.getVideoMsg("oX_DYt3AiupzsygSGIcqzw-l6NNo", "kx6s1D3vAhDioIyJhhM9kGXdv9u0SPbGIYrvF_U7VRA", "", "标题", "描述");


        WxCustomSendRequest request = new WxCustomSendRequest(model);

        client.execute(request);
    }
}