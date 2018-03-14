package com.app.wechat.code;

import com.whalin.MemCached.MemCachedClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

/**
 * <p>功 能：Memcached缓存操作工具类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年2月9日 下午2:27:32</p>
 * @author 王建
 * @version 1.0
 */
public class MemCachedUtil {
	private static final Logger LOG = LogManager.getLogger(MemCachedUtil.class);

	/** Memcached操作对象 */
	private static MemCachedClient cachedClient;

	static {
		if (cachedClient == null)
			cachedClient = new MemCachedClient();
	}

	/**
	 * 向缓存添加新的键值对
	 * <p>如果键已经存在，则之前的值将被替换</p>
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean set(String key, Object value) {
		return setExp(key, value, null);
	}

	/**
	 * 向缓存添加新的键值对
	 * <p>如果键已经存在，则之前的值将被替换</p>
	 * @param key
	 * @param value
	 * @param expire 过期时间
	 * @return
	 */
	public static boolean set(String key, Object value, Date expire) {
		return setExp(key, value, expire);
	}

	/**
	 * 向缓存添加新的键值对
	 * <p>如果键已经存在，则之前的值将被替换</p>
	 * @param key
	 * @param value
	 * @param expire 过期时间
	 * @return
	 */
	private static boolean setExp(String key, Object value, Date expire) {
		boolean flag = false;
		try {
			flag = cachedClient.set(key, value, expire);
		} catch (Exception e) {
			LOG.error("Memcached set命令出错", e);
		}
		return flag;
	}

	/**
	 * 向缓存添加新的键值对
	 * <p>仅当缓存中不存在键时添加</p>
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean add(String key, Object value) {
		return addExp(key, value, null);
	}

	/**
	 * 向缓存添加新的键值对
	 * <p>仅当缓存中不存在键时添加</p>
	 * @param key
	 * @param value
	 * @param expire 过期时间
	 * @return
	 */
	public static boolean add(String key, Object value, Date expire) {
		return addExp(key, value, expire);
	}

	/**
	 * 向缓存添加新的键值对
	 * <p>仅当缓存中不存在键时添加</p>
	 * @param key
	 * @param value
	 * @param expire 过期时间
	 * @return
	 */
	private static boolean addExp(String key, Object value, Date expire) {
		boolean flag = false;
		try {
			flag = cachedClient.add(key, value, expire);
		} catch (Exception e) {
			LOG.error("Memcached add命令出错", e);
		}
		return flag;
	}

	/**
	 * 替换缓存键的值
	 * <p>仅当键已经存在时替换</p>
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean replace(String key, Object value) {
		return replaceExp(key, value, null);
	}

	/**
	 * 替换缓存键的值
	 * <p>仅当键已经存在时替换</p>
	 * @param key
	 * @param value
	 * @param expire 过期时间
	 * @return
	 */
	public static boolean replace(String key, Object value, Date expire) {
		return replaceExp(key, value, expire);
	}

	/**
	 * 替换缓存键的值
	 * <p>仅当键已经存在时替换</p>
	 * @param key
	 * @param value
	 * @param expire 过期时间
	 * @return
	 */
	private static boolean replaceExp(String key, Object value, Date expire) {
		boolean flag = false;
		try {
			flag = cachedClient.replace(key, value, expire);
		} catch (Exception e) {
			LOG.error("Memcached replace命令出错", e);
		}
		return flag;
	}

	/**
	 * 检索缓存键的值
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		Object obj = null;
		try {
			obj = cachedClient.get(key);
		} catch (Exception e) {
			LOG.error("Memcached get命令出错", e);
		}
		return obj;
	}

	/**
	 * 删除缓存
	 * @param key
	 * @return
	 */
	public static boolean delete(String key) {
		boolean flag = false;
		try {
			flag = cachedClient.delete(key);
		} catch (Exception e) {
			LOG.error("Memcached delete命令出错", e);
		}
		return flag;
	}

	/**
	 * 清理缓存
	 * @return
	 */
	public static boolean flashAll() {
		boolean flag = false;
		try {
			flag = cachedClient.flushAll();
		} catch (Exception e) {
			LOG.error("Memcached flushAll命令出错", e);
		}
		return flag;
	}
}