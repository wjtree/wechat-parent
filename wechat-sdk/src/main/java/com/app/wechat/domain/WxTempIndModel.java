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
 * 模版消息-获取设置的行业信息API返回结果对象
 *
 * @author wjtree
 * @version 1.0
 */
public class WxTempIndModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 主行业
     */
    @JSONField(name = "first_class")
    private String firstClass;

    /**
     * 副行业
     */
    @JSONField(name = "second_class")
    private String secondClass;

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }
}