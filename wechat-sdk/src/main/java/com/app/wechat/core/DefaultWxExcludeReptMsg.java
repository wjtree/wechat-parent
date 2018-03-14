package com.app.wechat.core;

import com.app.wechat.internal.code.Symbol;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * <p>功 能：微信公众平台消息排重处理默认实现类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月22日 下午4:30:27</p>
 *
 * @author 王建
 * @version 1.0
 */
public class DefaultWxExcludeReptMsg implements WxExcludeReptMsg {
    /**
     * 消息排重专用缓存的有效期，单位：秒
     */
    public static final long MSG_EXPIRE = 16L;

    /**
     * 普通消息排重专用缓存的缓存项最大值
     */
    public static final long MSG_SIZE = 500000L;

    /**
     * 事件推送排重专用缓存的缓存项最大值
     */
    public static final long EVENT_SIZE = 100000L;

    /**
     * 推送排重专用缓存
     */
    private static Cache<String, String> evntCache = CacheBuilder.newBuilder().maximumSize(EVENT_SIZE).expireAfterWrite(MSG_EXPIRE, TimeUnit.SECONDS).build();

    /**
     * 普通消息排重专用缓存
     */
    private static Cache<String, String> msgCache = CacheBuilder.newBuilder().maximumSize(MSG_SIZE).expireAfterWrite(MSG_EXPIRE, TimeUnit.SECONDS).build();

    public boolean isEventRepeat(String fromUserName, Long createTime) {
        boolean flag = false;

        // 获取事件推送消息缓存键
        String key = StringUtils.joinWith(Symbol.UNDERSCORE.getSymbol(), fromUserName, createTime);
        // 查询是否存在缓存项
        String val = evntCache.getIfPresent(key);

        if (StringUtils.isNotBlank(val)) {
            // 如果缓存中存在该事件消息，说明是重复事件
            flag = true;
        } else {
            // 放入缓存
            evntCache.put(key, key);
        }

        return flag;
    }

    public boolean isMsgRepeat(String msgId) {
        boolean flag = false;

        // 查询是否存在缓存项
        String val = msgCache.getIfPresent(msgId);

        if (StringUtils.isNotBlank(val)) {
            // 如果缓存中存在该普通消息，说明是重复事件
            flag = true;
        } else {
            // 放入缓存
            msgCache.put(msgId, msgId);
        }

        return flag;
    }
}