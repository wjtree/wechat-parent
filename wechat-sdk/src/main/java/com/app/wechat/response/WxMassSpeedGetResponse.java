/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>功 能：获取群发速度API的响应信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月5日 下午3:45:34</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMassSpeedGetResponse extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 群发速度的级别
     */
    private Short speed;

    /**
     * 群发速度的真实值，单位：万/分钟
     */
    @JSONField(name = "realspeed")
    private Short realSpeed;

    public Short getSpeed() {
        return speed;
    }

    public void setSpeed(Short speed) {
        this.speed = speed;
    }

    public Short getRealSpeed() {
        return realSpeed;
    }

    public void setRealSpeed(Short realSpeed) {
        this.realSpeed = realSpeed;
    }
}