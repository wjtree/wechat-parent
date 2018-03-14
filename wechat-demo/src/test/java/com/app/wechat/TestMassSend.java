package com.app.wechat;

import com.app.wechat.code.WxConstant;
import com.app.wechat.core.DefaultWxClient;
import com.app.wechat.core.WxClient;
import com.app.wechat.domain.mass.WxMassPreviewModel;
import com.app.wechat.domain.mass.WxMassSendModel;
import com.app.wechat.domain.msg.WxTextMsgModel;
import com.app.wechat.domain.msg.WxVideoMsgModel;
import com.app.wechat.internal.code.Constant;
import com.app.wechat.internal.code.WxMsgType;
import com.app.wechat.internal.util.WxMassUtil;
import com.app.wechat.internal.util.WxMsgUtil;
import com.app.wechat.request.WxMassGetRequest;
import com.app.wechat.request.WxMassPreviewRequest;
import com.app.wechat.request.WxMassSendRequest;
import com.app.wechat.request.WxMediaUploadVideoRequest;
import com.app.wechat.response.WxMassSendResponse;
import org.junit.Test;

/**
 * @author Administrator
 * @version 1.0
 */
public class TestMassSend {
    WxClient client = new DefaultWxClient(WxConstant.APP_ID, WxConstant.APP_SECRET);

    String OpenId = "oX_DYt3AiupzsygSGIcqzw-l6NNo";

    @Test
    public void TestMaterial() throws Exception {
        // WxMaterialAddRequest request = new WxMaterialAddRequest("E:\\WorkSpace\\Resouce\\timg.jpg", WxMediaType.THUMB);
        // WxMaterialAddRequest request = new WxMaterialAddRequest("E:\\WorkSpace\\Resouce\\test.mp4", WxMediaType.VIDEO, "欢迎标题", "欢迎描述");

        // WxMediaUploadRequest request = new WxMediaUploadRequest("E:\\WorkSpace\\Resouce\\timg.jpg", WxMediaType.IMAGE);
        // WxMediaUploadRequest request = new WxMediaUploadRequest("E:\\WorkSpace\\Resouce\\test.mp4", WxMediaType.VIDEO);

        WxVideoMsgModel model = WxMsgUtil.getWxVideoMsgModel("mSkwZfH4uzfW_2BB-Tf4r68qATwJhPzaK2n_c65MkrwWNq8b1-StcmHieIyEf-LR", "标题", "描述");
        WxMediaUploadVideoRequest request = new WxMediaUploadVideoRequest(model);

        client.execute(request);
    }

    @Test
    public void TestMassSend() throws Exception {
        // 1 上传图文消息内的图片获取URL
        // WxMediaUploadImgRequest request = new WxMediaUploadImgRequest("E:\\WorkSpace\\Resouce\\head.jpg");

        // 2 上传图文消息素材
        // WxMediaUploadRequest request0 = new WxMediaUploadRequest("E:\\WorkSpace\\Resouce\\timg.jpg", WxMediaType.IMAGE);
        // WxMediaUploadResponse response0 = client.execute(request0);
        //
        // WxNewsMsgModel newsMsgModel = WxMsgUtil.getWxNewsMsgModel(response0.getMediaId(), "标题", "内容");
        // WxMediaUploadNewsRequest request1 = new WxMediaUploadNewsRequest(newsMsgModel);
        // WxMediaUploadNewsResponse response1 = client.execute(request1);

        // 素材准备
        WxMsgType msgType = WxMsgType.TEXT;
        // WxMpNewsMsgModel mpNewsMsgModel = WxMsgUtil.getWxMpNewsMsgModel(response1.getMediaId());
        WxTextMsgModel textMsgModel = WxMsgUtil.getWxTextMsgModel("欢迎");

        // 5 预览接口
        // WxMassPreviewModel previewModel = WxMassUtil.getWxMassPreviewModelById(OpenId, msgType, textMsgModel);
        WxMassPreviewModel previewModel = WxMassUtil.getWxMassPreviewModelByName("wjtree", msgType, textMsgModel);
        WxMassPreviewRequest request5 = new WxMassPreviewRequest(previewModel);
        client.execute(request5);

        // 3 进行群发
        // 根据标签进行群发
        // WxMassSendModel massSendAllModel = WxMassUtil.getWxMassSendModel(Constant.YES, String.valueOf(System.currentTimeMillis()), msgType, textMsgModel);
        // WxMassSendAllRequest request2 = new WxMassSendAllRequest(massSendAllModel);
        // WxMassSendAllResponse response2 = client.execute(request2);

        // 根据OpenID列表群发
        String[] openIds = {"oSaeBtwPOpWYDKdePC_K-Lu6KswY", "oSaeBt4ay221ZzXk2hzig1psi9ZA"};
        WxMassSendModel massSendModel = WxMassUtil.getWxMassSendModel(openIds, Constant.YES, String.valueOf(System.currentTimeMillis()), msgType, textMsgModel);
        WxMassSendRequest request3 = new WxMassSendRequest(massSendModel);
        WxMassSendResponse response3 = client.execute(request3);

        // 6 查询群发消息发送状态
        WxMassGetRequest request6 = new WxMassGetRequest(response3.getMsgId());
        client.execute(request6);

        // 4 删除群发
        // WxMassDelRequest request4 = new WxMassDelRequest(response2.getMsgId());
        // WxMassDelResponse response4 = client.execute(request4);

        // 7 控制群发速度
        // WxMassSpeedSetRequest request7 = new WxMassSpeedSetRequest(WxMassSpeed.S0);
        // WxMassSpeedGetRequest request8 = new WxMassSpeedGetRequest();
        // client.execute(request8);
    }

    public void test() throws Exception {
        // WxNewsMsgModel model = WxMsgUtil.getWxNewsMsgModel("36KPUMl5PSGRUoZ5ffTtlu996dWg4Pdokd-qUbUPXz8", "标题", "内容");
        // WxMaterialAddNewsRequest request = new WxMaterialAddNewsRequest(model);
    }
}