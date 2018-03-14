/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.internal.util;

import com.alibaba.fastjson.JSONObject;
import com.app.wechat.domain.WxUploadModel;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众平台素材上传API工具类
 *
 * @author wjtree
 * @version 1.0
 */
public class WxUploadUtil {
    /**
     * 封装新增永久视频素材附加表单
     *
     * @param title        视频素材的标题
     * @param introduction 视频素材的描述
     * @return Map 视频素材附加表单
     */
    public static Map<String, Object> getVideoFormData(String title, String introduction) {
        // 附加表单的内容
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("title", title);
        jsonObj.put("introduction", introduction);

        // 附加表单的名称
        Map<String, Object> formData = new HashMap<>();
        formData.put("description", jsonObj.toString());

        return formData;
    }

    /**
     * 封装模拟表单form-data媒体文件标识对象
     * <p>默认上传文件的表单名为“msg”，无附加表单</p>
     *
     * @param pathName HttpClient模拟表单请求的待上传文件路径
     * @return WxUploadModel
     */
    public static WxUploadModel getWxFormDataModel(String pathName) {
        return getWxFormDataModel(pathName, null);
    }

    /**
     * 封装模拟表单form-data媒体文件标识对象
     * <p>默认上传文件的表单名为“msg”</p>
     *
     * @param pathName HttpClient模拟表单请求的待上传文件路径
     * @param formData HttpClient模拟表单请求的form-data中媒体文件标识
     * @return WxUploadModel
     */
    public static WxUploadModel getWxFormDataModel(String pathName, Map<String, Object> formData) {
        return getWxFormDataModel("media", pathName, formData);
    }

    /**
     * 封装模拟表单form-data媒体文件标识对象
     *
     * @param name     HttpClient模拟表单请求的表单名称
     * @param pathName HttpClient模拟表单请求的待上传文件路径
     * @param formData HttpClient模拟表单请求的form-data中媒体文件标识
     * @return WxUploadModel
     */
    public static WxUploadModel getWxFormDataModel(String name, String pathName, Map<String, Object> formData) {
        File file = new File(pathName);
        return getWxFormDataModel(name, file, formData);
    }

    /**
     * 封装模拟表单form-data媒体文件标识对象
     *
     * @param name     HttpClient模拟表单请求的表单名称
     * @param file     HttpClient模拟表单请求的待上传文件
     * @param formData HttpClient模拟表单请求的form-data中媒体文件标识
     * @return WxUploadModel
     */
    public static WxUploadModel getWxFormDataModel(String name, File file, Map<String, Object> formData) {
        WxUploadModel model = new WxUploadModel();
        model.setName(name);
        model.setFile(file);
        model.setFormData(formData);
        return model;
    }
}