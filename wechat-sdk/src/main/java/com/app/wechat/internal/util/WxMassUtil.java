/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.internal.util;

import com.app.wechat.domain.WxObject;
import com.app.wechat.domain.mass.*;
import com.app.wechat.domain.msg.*;
import com.app.wechat.internal.code.WxMsgType;

/**
 * 群发消息API请求工具类
 *
 * @author wjtree
 * @version 1.0
 */
public class WxMassUtil {
    /**
     * 封装查询群发消息发送状态API的参数
     *
     * @param msgId 发送出去的消息ID
     * @return WxMassModel
     */
    public static WxMassModel getWxMassModel(Long msgId) {
        return getWxMassModel(msgId, null);
    }

    /**
     * 封装删除群发消息API的参数
     *
     * @param msgId      发送出去的消息ID
     * @param articleIdx 要删除的文章在图文消息中的位置
     * @return WxMassModel
     */
    public static WxMassModel getWxMassModel(Long msgId, Short articleIdx) {
        WxMassModel model = new WxMassModel();
        model.setMsgId(msgId);
        model.setArticleIdx(articleIdx);
        return model;
    }

    /**
     * 用于根据标签进行群发API，设定图文消息的接收者
     * <p>若is_to_all值为true，可不填写tag_id</p>
     *
     * @param isToAll 用于设定是否向全部用户发送
     * @param tagId   群发到的标签的tag_id
     * @return WxMassFilterModel
     */
    public static WxMassFilterModel getWxMassFilterModel(Boolean isToAll, Short tagId) {
        WxMassFilterModel model = new WxMassFilterModel();
        model.setIsToAll(isToAll);
        model.setTagId(tagId);
        return model;
    }

    /**
     * 封装“根据标签进行群发”API的请求对象
     * <p>群发给所有用户，不对标签进行过滤</p>
     *
     * @param sendIgnoreReprint 文章被判定为转载时，是否继续群发
     * @param clientMsgId       群发消息的客户端编号
     * @param msgType           群发消息的类型
     * @param object            群发消息内容
     * @return WxMassSendModel
     */
    public static WxMassSendModel getWxMassSendModel(Short sendIgnoreReprint, String clientMsgId, WxMsgType msgType, WxObject object) {
        return getWxMassSendModel(true, null, sendIgnoreReprint, clientMsgId, msgType, object);
    }

    /**
     * 封装“根据标签进行群发”API的请求对象
     *
     * @param isToAll           用于设定是否向全部用户发送
     * @param tagId             群发到的标签的tag_id
     * @param sendIgnoreReprint 文章被判定为转载时，是否继续群发
     * @param clientMsgId       群发消息的客户端编号
     * @param msgType           群发消息的类型
     * @param object            群发消息内容
     * @return WxMassSendModel
     */
    public static WxMassSendModel getWxMassSendModel(Boolean isToAll, Short tagId, Short sendIgnoreReprint, String clientMsgId, WxMsgType msgType, WxObject object) {
        WxMassFilterModel filter = getWxMassFilterModel(isToAll, tagId);
        return getWxMassSendModel(filter, null, sendIgnoreReprint, clientMsgId, msgType, object);
    }

    /**
     * 封装“根据OpenID列表群发”API的请求对象
     *
     * @param toUser            填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param sendIgnoreReprint 文章被判定为转载时，是否继续群发
     * @param clientMsgId       群发消息的客户端编号
     * @param msgType           群发消息的类型
     * @param object            群发消息内容
     * @return WxMassSendModel
     */
    public static WxMassSendModel getWxMassSendModel(String[] toUser, Short sendIgnoreReprint, String clientMsgId, WxMsgType msgType, WxObject object) {
        return getWxMassSendModel(null, toUser, sendIgnoreReprint, clientMsgId, msgType, object);
    }

    /**
     * 封装群发消息API的请求对象
     *
     * @param filter            根据标签进行群发的过滤对象
     * @param toUser            根据OpenID列表群发的微信号数组
     * @param sendIgnoreReprint 文章被判定为转载时，是否继续群发
     * @param clientMsgId       群发消息的客户端编号
     * @param msgType           群发消息的类型
     * @param object            群发消息内容
     * @return WxMassSendModel
     */

    public static WxMassSendModel getWxMassSendModel(WxMassFilterModel filter, String[] toUser, Short sendIgnoreReprint, String clientMsgId, WxMsgType msgType, WxObject object) {
        WxMassSendModel model = new WxMassSendModel();
        model.setFilter(filter);
        model.setToUser(toUser);
        model.setSendIgnoreReprint(sendIgnoreReprint);
        model.setClientMsgId(clientMsgId);
        // 装载消息对象
        bindMassMsg(model, msgType, object);

        return model;
    }

    /**
     * 封装预览群发消息API的请求对象
     * <p>使用微信用户的openId</p>
     *
     * @param toUser  接收消息用户对应该公众号的openid
     * @param msgType 群发消息的类型
     * @param object  群发消息内容
     * @return WxMassPreviewModel
     */
    public static WxMassPreviewModel getWxMassPreviewModelById(String toUser, WxMsgType msgType, WxObject object) {
        return getWxMassPreviewModel(toUser, null, msgType, object);
    }

    /**
     * 封装预览群发消息API的请求对象
     * <p>使用微信用户的微信号</p>
     *
     * @param toWxName 接收消息用户的微信号
     * @param msgType  群发消息的类型
     * @param object   群发消息内容
     * @return WxMassPreviewModel
     */
    public static WxMassPreviewModel getWxMassPreviewModelByName(String toWxName, WxMsgType msgType, WxObject object) {
        return getWxMassPreviewModel(null, toWxName, msgType, object);
    }

    /**
     * 封装预览群发消息API的请求对象
     *
     * @param toUser   接收消息用户对应该公众号的openid
     * @param toWxName 接收消息用户的微信号
     * @param msgType  群发消息的类型
     * @param object   群发消息内容
     * @return WxMassPreviewModel
     */
    public static WxMassPreviewModel getWxMassPreviewModel(String toUser, String toWxName, WxMsgType msgType, WxObject object) {
        WxMassPreviewModel model = new WxMassPreviewModel();
        model.setToUser(toUser);
        model.setToWxName(toWxName);
        // 装载消息对象
        bindMassMsg(model, msgType, object);

        return model;
    }

    /**
     * 装载“群发消息”和“预览群发消息”API的公共消息属性
     *
     * @param model   群发消息对象
     * @param msgType 群发消息类型
     * @param object  消息对象
     */
    private static <T extends WxMassBaseModel> void bindMassMsg(T model, WxMsgType msgType, WxObject object) {
        // 装载群发消息类型
        model.setMsgType(msgType != null ? msgType.name().toLowerCase() : null);

        // 根据消息类型，装载对应类型的群发消息对象
        if (WxMsgType.MPNEWS.equals(msgType) && object instanceof WxMpNewsMsgModel)
            model.setMpNews((WxMpNewsMsgModel) object);
        else if (WxMsgType.TEXT.equals(msgType) && object instanceof WxTextMsgModel)
            model.setText((WxTextMsgModel) object);
        else if (WxMsgType.VOICE.equals(msgType) && object instanceof WxVoiceMsgModel)
            model.setVoice((WxVoiceMsgModel) object);
        else if (WxMsgType.IMAGE.equals(msgType) && object instanceof WxImgMsgModel)
            model.setImage((WxImgMsgModel) object);
        else if (WxMsgType.MPVIDEO.equals(msgType) && object instanceof WxVideoMsgModel)
            model.setMpVideo((WxVideoMsgModel) object);
        else if (WxMsgType.WXCARD.equals(msgType) && object instanceof WxCardMsgModel)
            model.setWxCard((WxCardMsgModel) object);
    }
}