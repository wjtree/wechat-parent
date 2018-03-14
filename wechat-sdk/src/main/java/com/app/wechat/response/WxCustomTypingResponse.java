package com.app.wechat.response;

/**
 * <p>功 能：客服输入状态API的响应信息</p>
 * <p>描 述：开发者可通过调用“客服输入状态”接口，返回客服当前输入状态给用户</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 * <br/>
 * <p>注 意：此接口需要客服消息接口权限</p>
 * <ol>
 * <li>如果不满足发送客服消息的触发条件，则无法下发输入状态</li>
 * <li>下发输入状态，需要客服之前30秒内跟用户有过消息交互</li>
 * <li>在输入状态中（持续15s），不可重复下发输入态</li>
 * <li>在输入状态中，如果向用户下发消息，会同时取消输入状态</li>
 * </ol>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCustomTypingResponse extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;
}