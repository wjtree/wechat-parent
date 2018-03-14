package com.app.wechat.core;

import com.app.wechat.internal.code.Symbol;
import com.app.wechat.internal.exception.WxApiException;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * <p>功 能：微信公众号接口调用凭证管理器默认实现类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月4日 下午6:07:51</p>
 *
 * @author 王建
 * @version 1.0
 */
public class DefaultWxAccessToken extends AbstractWxAccessToken {
    /**
     * 接口调用凭证专用缓存的缓存键格式，第一个字符串为appId，第二个字符串为appSecret
     */
    private static final String KEY_FORMAT = "accToken_%1$s_%2$s";

    /**
     * 使用“饿汉单例模式”实例化类
     */
    private static DefaultWxAccessToken instance = new DefaultWxAccessToken();

    /**
     * 接口调用凭证专用缓存
     */
    private static LoadingCache<String, String> accTokenCache = null;

    static {
        if (accTokenCache == null) {
            // 接口调用凭证专用缓存的大小，即最大可以存放的公众号凭证数量
            long size = 5;
            // 接口调用凭证专用缓存的有效期，单位：秒，目前是2小时有效期
            long expireTime = 7200;
            // 接口调用凭证专用缓存的刷新时间，单位：秒，此处取缓存有效期的3/4作为刷新时间，即1.5小时
            long refreshTime = expireTime / 4 * 3;

            // 初始化接口调用凭证专用缓存
            accTokenCache = CacheBuilder.newBuilder().maximumSize(size).expireAfterWrite(expireTime, TimeUnit.SECONDS).refreshAfterWrite(refreshTime, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {

                public String load(String key) throws WxApiException {
                    // 分割缓存键，获取appId和appSecret
                    String[] arr = key.split(Symbol.UNDERSCORE.getSymbol());
                    // 调用API获取接口调用凭证
                    return requestToken(arr[1], arr[2]);
                }

            });
        }
    }

    private DefaultWxAccessToken() {
    }

    public static DefaultWxAccessToken getInstance() {
        return instance;
    }

    public String getToken(String appId, String appSecret) throws WxApiException {
        String token = null;

        // 获取缓存键
        String key = String.format(KEY_FORMAT, appId, appSecret);
        // 获取缓存值
        synchronized (accTokenCache) {
            try {
                token = accTokenCache.get(key);
            } catch (ExecutionException e) {
                LOG.error("从Guava Cache中获取接口调用凭证出错", e);
            }
        }

        if (LOG.isDebugEnabled())
            LOG.debug("获取接口调用凭证成功，appId：{}，accessToken：{}", appId, token);

        return token;
    }

    public String refreshToken(String appId, String appSecret) throws WxApiException {
        // 调用API获取接口调用凭证
        String token = null;

        // 获取缓存键
        String key = String.format(KEY_FORMAT, appId, appSecret);
        // 将刷新后的凭证存入缓存
        synchronized (accTokenCache) {
            token = requestToken(appId, appSecret);
            accTokenCache.put(key, token);
        }

        if (LOG.isDebugEnabled())
            LOG.debug("刷新接口调用凭证成功，appId：{}，accessToken：{}", appId, token);

        return token;
    }
}