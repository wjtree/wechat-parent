/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat;

import com.app.wechat.code.WxConstant;
import com.app.wechat.core.DefaultWxClient;
import com.app.wechat.core.WxClient;
import com.app.wechat.domain.WxTempSendDataModel;
import com.app.wechat.domain.WxTempSendModel;
import com.app.wechat.internal.util.WxTempUtil;
import com.app.wechat.request.WxTempSendRequest;
import org.junit.Test;

import java.util.Map;

/**
 * @author wjtree
 * @version 1.0
 */
public class TestTemplate {
    WxClient client = new DefaultWxClient(WxConstant.APP_ID, WxConstant.APP_SECRET);

    @Test
    public void TestTemplate() throws Exception {
        // WxTempSetIndRequest request = new WxTempSetIndRest(WxIndustry.I1, WxIndustry.I2);
        // WxTempGetIndRequest request = new WxTempGetIndRequest();
        // WxTempAddRequest request = new WxTempAddRequest("11");
        // WxTempGetRequest request = new WxTempGetRequest();
        // WxTempDelRequest request = new WxTempDelRequest("IZZM-JYBwwNayAR9xIgvsqlW9SU27OmVDyjuJeLNxNs");

        Map<String, WxTempSendDataModel> map = WxTempUtil.bindDataModel("二号");
        WxTempSendModel model = WxTempUtil.getWxTempSendModelByUrl("oX_DYt3AiupzsygSGIcqzw-l6NNo", "Y1EcYULyeztmMOQjvx_sgA81PpPv7QY2P_ClxOS36XM", "http://m.baidu.com", map);
        WxTempSendRequest request = new WxTempSendRequest(model);

        client.execute(request);
    }
}