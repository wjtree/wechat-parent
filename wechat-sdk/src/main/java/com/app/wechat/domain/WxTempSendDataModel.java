/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.domain;

/**
 * 模版消息-发送模板消息API请求对象
 *
 * @author wjtree
 * @version 1.0
 */
public class WxTempSendDataModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 模板内容
     */
    private String value;

    /**
     * 模板内容字体颜色，不填默认为黑色
     */
    private String color;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}