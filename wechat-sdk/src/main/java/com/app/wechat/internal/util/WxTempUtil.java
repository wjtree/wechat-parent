/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.internal.util;

import com.app.wechat.domain.WxTempSendDataModel;
import com.app.wechat.domain.WxTempSendModel;
import com.app.wechat.domain.msg.WxMiniProMsgModel;
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信公众平台模版消息API工具类
 *
 * @author wjtree
 * @version 1.0
 */
public class WxTempUtil {
    /**
     * 封装模版消息参数对象
     * <p>默认使黑色字体</p>
     *
     * @param value 参数值
     * @return WxTempSendDataModel 模版消息参数对象
     */
    public static WxTempSendDataModel getWxTempSendDataModel(Object value) {
        return getWxTempSendDataModel(value, null);
    }

    /**
     * 封装模版消息参数对象
     *
     * @param value 参数值
     * @param color 参数颜色
     * @return WxTempSendDataModel 模版消息参数对象
     */
    public static WxTempSendDataModel getWxTempSendDataModel(Object value, String color) {
        WxTempSendDataModel model = new WxTempSendDataModel();
        model.setValue(value != null ? value.toString() : null);
        model.setColor(color);
        return model;
    }

    /**
     * 封装模版消息内容
     *
     * @param objects 模版消息内容文本
     * @return Map
     */
    public static Map<String, WxTempSendDataModel> bindDataModel(Object... objects) {
        List<WxTempSendDataModel> list = Lists.newArrayList();
        WxTempSendDataModel model = null;

        for (int i = 0; i < objects.length; i++) {
            model = getWxTempSendDataModel(objects[i]);
            list.add(model);
        }

        return bindDataModel(list);
    }

    /**
     * 封装模版消息内容
     *
     * @param dataModels 模版消息内容
     * @return Map
     */
    public static Map<String, WxTempSendDataModel> bindDataModel(WxTempSendDataModel... dataModels) {
        List<WxTempSendDataModel> list = Lists.newArrayList(dataModels);
        return bindDataModel(list);
    }

    /**
     * 封装模版消息内容
     *
     * @param dataModels 模版消息内容
     * @return Map
     */
    public static Map<String, WxTempSendDataModel> bindDataModel(List<WxTempSendDataModel> dataModels) {
        Map<String, WxTempSendDataModel> map = new HashMap<>();
        String key = null;
        WxTempSendDataModel value = null;

        for (int i = 0; i < dataModels.size(); i++) {
            key = "keyword" + (i + 1);
            value = dataModels.get(i);

            map.put(key, value);
        }

        return map;
    }

    /**
     * 封装发送模版消息接口参数对象
     * <p>点击模版消息打开小程序页面</p>
     *
     * @param toUser     接收者openid
     * @param templateId 模板ID
     * @param appId      小程序的appid，要求小程序的appid需要与公众号有关联关系
     * @param pagePath   小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
     * @param data       模板数据
     * @return WxTempSendModel
     */
    public static WxTempSendModel getWxTempSendModelByMini(String toUser, String templateId, String appId, String pagePath, Map<String, WxTempSendDataModel> data) {
        WxMiniProMsgModel miniProMsgModel = WxMsgUtil.getWxMiniProMsgModel(null, appId, pagePath, null);
        return getWxTempSendModel(toUser, templateId, null, miniProMsgModel, data);
    }

    /**
     * 封装发送模版消息接口参数对象
     * <p>点击模版消息打开url页面</p>
     *
     * @param toUser     接收者openid
     * @param templateId 模板ID
     * @param url        模板跳转链接
     * @param data       模板数据
     * @return WxTempSendModel
     */
    public static WxTempSendModel getWxTempSendModelByUrl(String toUser, String templateId, String url, Map<String, WxTempSendDataModel> data) {
        return getWxTempSendModel(toUser, templateId, url, null, data);
    }

    /**
     * 封装发送模版消息接口参数对象
     *
     * @param toUser      接收者openid
     * @param templateId  模板ID
     * @param url         模板跳转链接
     * @param miniProgram 跳小程序所需数据，不需跳小程序可不用传该数据
     * @param data        模板数据
     * @return WxTempSendModel
     */

    public static WxTempSendModel getWxTempSendModel(String toUser, String templateId, String url, WxMiniProMsgModel miniProgram, Map<String, WxTempSendDataModel> data) {
        WxTempSendModel model = new WxTempSendModel();
        model.setToUser(toUser);
        model.setTemplateId(templateId);
        model.setUrl(url);
        model.setMiniProgram(miniProgram);
        model.setData(data);
        return model;
    }
}