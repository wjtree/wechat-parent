package com.app.wechat.domain;

import java.io.File;
import java.util.Map;

/**
 * 微信公众平台上传多媒体API-模拟表单form-data媒体文件标识对象
 *
 * @author Administrator
 * @version 1.0
 */
public class WxUploadModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * HttpClient模拟表单请求的表单名称
     */
    private String name;

    /**
     * HttpClient模拟表单请求的待上传文件
     */
    private File file;

    /**
     * HttpClient模拟表单请求的附加表单
     */
    private Map<String, Object> formData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Map<String, Object> getFormData() {
        return formData;
    }

    public void setFormData(Map<String, Object> formData) {
        this.formData = formData;
    }
}