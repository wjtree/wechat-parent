package com.app.wechat.internal.code;

/**
 * <p>功 能：微信公众号媒体文件类型枚举</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午5:39:03</p>
 *
 * @author 王建
 * @version 1.0
 */
public enum WxMediaType {
    /**
     * 图片
     */
    IMAGE, /**
     * 语音
     */
    VOICE, /**
     * 视频
     */
    VIDEO, /**
     * 缩略图，主要用于视频与音乐格式的缩略图
     */
    THUMB, /**
     * 图文消息
     */
    NEWS;
}