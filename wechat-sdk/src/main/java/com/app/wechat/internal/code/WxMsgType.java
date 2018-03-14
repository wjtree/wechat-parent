package com.app.wechat.internal.code;

/**
 * <p>功 能：微信公众号消息类型枚举</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 上午11:20:11</p>
 *
 * @author 王建
 * @version 1.0
 */
public enum WxMsgType {
    /**
     * 文本消息
     */
    TEXT, /**
     * 语音消息
     */
    VOICE, /**
     * 图片消息
     */
    IMAGE, /**
     * 视频消息
     */
    VIDEO, /**
     * 视频消息，“群发消息”API使用
     */
    MPVIDEO, /**
     * 小视频消息，“接收普通消息”API使用
     */
    SHORTVIDEO, /**
     * 地理位置消息，“接收普通消息”API使用
     */
    LOCATION, /**
     * 链接消息，“接收普通消息”API使用
     */
    LINK, /**
     * 事件，“接收普通消息”API使用
     */
    EVENT, /**
     * 音乐消息，“被动回复消息和客服消息”API使用
     */
    MUSIC, /**
     * 图文消息（点击跳转到外链），“被动回复消息和客服消息”API使用
     */
    NEWS, /**
     * 图文消息（点击跳转到图文消息页面），“客服消息”API使用
     */
    MPNEWS, /**
     * 卡券消息，“客服消息”API使用
     */
    WXCARD, /**
     * 小程序卡片，“客服消息”API使用
     */
    MINIPROGRAMPAGE;
}