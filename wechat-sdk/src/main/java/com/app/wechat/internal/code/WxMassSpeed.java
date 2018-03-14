/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.internal.code;

/**
 * 微信公众平台群发消息速度枚举
 *
 * @author wjtree
 * @version 1.0
 */
public enum WxMassSpeed {
    S0(0, 80), S1(1, 60), S2(2, 45), S3(3, 30), S4(4, 10);

    /**
     * 群发速度的级别
     */
    private final int speed;

    /**
     * 群发速度的真实值，单位：万/分钟
     */
    private final int realSpeed;

    WxMassSpeed(int speed, int realSpeed) {
        this.speed = speed;
        this.realSpeed = realSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRealSpeed() {
        return realSpeed;
    }
}