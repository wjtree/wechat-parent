/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 模版消息-获取模板列表API返回结果对象
 *
 * @author wjtree
 * @version 1.0
 */
public class WxTempModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 模板ID
     */
    @JSONField(name = "template_id")
    private String templateId;

    /**
     * 模板标题
     */
    private String title;

    /**
     * 模板所属行业的一级行业
     */
    @JSONField(name = "primary_industry")
    private String primaryInd;

    /**
     * 模板所属行业的二级行业
     */
    @JSONField(name = "deputy_industry")
    private String deputyInd;

    /**
     * 模板内容
     */
    private String content;

    /**
     * 模板示例
     */
    private String example;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimaryInd() {
        return primaryInd;
    }

    public void setPrimaryInd(String primaryInd) {
        this.primaryInd = primaryInd;
    }

    public String getDeputyInd() {
        return deputyInd;
    }

    public void setDeputyInd(String deputyInd) {
        this.deputyInd = deputyInd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}