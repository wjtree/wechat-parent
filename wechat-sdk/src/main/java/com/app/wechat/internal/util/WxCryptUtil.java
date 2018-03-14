package com.app.wechat.internal.util;

import com.app.wechat.domain.WxMsgDto;
import com.app.wechat.domain.WxSignDto;
import com.app.wechat.domain.reply.WxRepMsgCryptDto;
import com.app.wechat.internal.code.ByteGroup;
import com.app.wechat.internal.code.CryptType;
import com.app.wechat.internal.code.Symbol;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * <p>功 能：微信公众号消息加解密工具类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月27日 下午2:45:32</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCryptUtil {
    private static final Logger LOG = LogManager.getLogger(WxCryptUtil.class);

    /**
     * 检查微信公众号是否启用消息加密模式
     *
     * @param encryptType
     * @return
     */
    public static boolean isMsgCrypt(String encryptType) {
        return StringUtils.equalsIgnoreCase(encryptType, CryptType.AES.name());
    }

    /**
     * 加密微信公众号回复的消息
     *
     * @param repMsg 回复消息的明文
     * @param token  微信公众号令牌Token
     * @param aesKey 消息加解密密钥(EncodingAESKey)
     * @param appId  微信公众号AppID
     * @return 微信公众号回复消息的密文XML字符串
     * @throws Exception
     */
    public static String encryptMsg(String repMsg, String token, String aesKey, String appId) {
        String result = null;
        try {
            // 获取微信公众号回复消息的密文
            String encrypt = encrypt(repMsg, aesKey, appId);

            // 生成消息签名的时间戳
            String timeStamp = DateUtil.getMillisTimestamp();
            // 生成消息签名的随机字符串
            String nonce = StringUtil.getNonceStr(10);
            // 生成消息签名
            String msgSignature = WxSignUtil.getSignature(token, timeStamp, nonce, encrypt);

            // 将以上参数装载到被动回复加密消息对象中
            WxRepMsgCryptDto dto = new WxRepMsgCryptDto(msgSignature, timeStamp, nonce, encrypt);
            // 将JavaBean转换为XML字符串
            result = XmlUtil.toXmlWithCData(dto);
        } catch (Exception e) {
            LOG.error("加密微信公众号回复的消息出错", e);
        }
        return result;
    }

    /**
     * 解密微信公众平台发送的消息
     *
     * @param inStr     请求输入流转换的字符串
     * @param wxSignDto 请求参数，包含验签参数
     * @param token     微信公众号签名校验令牌Token
     * @param aesKey    消息加解密密钥
     * @param appId     微信公众号AppID
     * @return 消息明文
     * @throws Exception
     */
    public static String decryptMsg(String inStr, WxSignDto wxSignDto, String token, String aesKey, String appId) {
        // 默认不加密，原样返回
        String result = inStr;
        try {
            // 将XML字符串转化为微信基础消息对象，用于提取消息密文
            WxMsgDto wxMsgDto = XmlUtil.toBeanWithCData(inStr, WxMsgDto.class);

            // 验证消息体签名
            boolean flag = WxSignUtil.checkCryptSignature(token, wxSignDto, wxMsgDto);
            // 签名校验通过，解密消息
            if (flag) {
                // 获取解密后的明文
                result = decrypt(wxMsgDto.getEncrypt(), aesKey, appId);

                if (LOG.isDebugEnabled())
                    LOG.debug("微信公众平台请求消息解密结果：{}", result);
            }
        } catch (Exception e) {
            LOG.error("解密微信公众平台发送的消息出错", e);
        }
        return result;
    }

    /**
     * 加密微信公众号回复的消息
     *
     * @param repMsg 回复消息的明文
     * @param aesKey 消息加解密密钥(EncodingAESKey)
     * @param appId  微信公众号AppID
     * @return 微信公众号回复消息的密文
     * @throws Exception
     */
    private static String encrypt(String repMsg, String aesKey, String appId) throws Exception {
        // 1.声明字节型数组容器对象
        ByteGroup byteGroup = new ByteGroup();

        // 2.随机生成16位字符串，并转换为字节数组
        byte[] randomStrBytes = StringUtil.getNonceStr(16).getBytes(StandardCharsets.UTF_8.name());
        // 3.将微信公众号回复的消息内容（XML字符串）转换为字节数组
        byte[] repMsgBytes = repMsg.getBytes(StandardCharsets.UTF_8.name());
        // 4.根据回复消息的字节数组，生成4个字节的网络字节序
        byte[] networkBytesOrder = getNetworkBytesOrder(repMsgBytes.length);
        // 5.将微信公众号AppID转换为字节数组
        byte[] appIdBytes = appId.getBytes(StandardCharsets.UTF_8.name());

        // 6.将以上生成的各个字节数组按照指定顺序加入字节容器中
        // 严格按照该顺序加入：randomStr + networkBytesOrder + repMsg + appId
        byteGroup.addBytes(randomStrBytes);
        byteGroup.addBytes(networkBytesOrder);
        byteGroup.addBytes(repMsgBytes);
        byteGroup.addBytes(appIdBytes);

        // 7.使用自定义的填充方式对明文进行补位填充
        byte[] padBytes = PKCS7Util.encode(byteGroup.size());
        // 8.将补位填充的字节数组加入字节容器中
        byteGroup.addBytes(padBytes);

        // 9.获得最终的字节流, 未加密
        byte[] unencrypted = byteGroup.toBytes();

        // 10.获取AES加解密原始密钥，注意需要在公众号网站上的EncodingAESKey后加上一个等号“=”
        byte[] key = Base64.decodeBase64(aesKey + Symbol.EQUALS.getSymbol());
        // 11.根据原始密钥获取AES密码器所需的密钥参数
        byte[] iv = Arrays.copyOfRange(key, 0, 16);
        // 12.获取加密后的回复消息，以字符串形式返回
        return AesUtil.encryptCBC(unencrypted, key, iv);
    }

    /**
     * 解密微信公众平台发送的消息
     *
     * @param encrypt 消息密文
     * @param aesKey  消息加解密密钥
     * @param appId   微信公众号AppID
     * @return 消息明文
     * @throws Exception
     */
    private static String decrypt(String encrypt, String aesKey, String appId) throws Exception {
        // 1.获取AES加解密原始密钥，注意需要在公众号网站上的EncodingAESKey后加上一个等号“=”
        byte[] key = Base64.decodeBase64(aesKey + Symbol.EQUALS.getSymbol());
        // 2.根据原始密钥获取AES密码器所需的密钥参数
        byte[] iv = Arrays.copyOfRange(key, 0, 16);
        // 3.获取解密后的消息体，字节数组形式
        byte[] original = AesUtil.decryptCBC(encrypt, key, iv);

        // 4.去除解密后的字节数组中的补位字符
        byte[] bytes = PKCS7Util.decode(original);

        // 5.分离16位随机字符串，网络字节序和AppId
        byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
        int xmlLength = recoverNetworkBytesOrder(networkOrder);

        // 6.获取明文中的消息内容
        byte[] xmlBytes = Arrays.copyOfRange(bytes, 20, 20 + xmlLength);
        String xmlContent = new String(xmlBytes, StandardCharsets.UTF_8.name());

        // 7.获取明文中的AppId，用于和本地保存的AppId比较，校验二者是否一致
        byte[] appIdBytes = Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length);
        String from_appid = new String(appIdBytes, StandardCharsets.UTF_8.name());

        // 8.校验密文中的AppId和本地保存的AppId是否一致，不一致返回空
        return StringUtils.equalsIgnoreCase(appId, from_appid) ? xmlContent : null;
    }

    /**
     * 生成4个字节的网络字节序
     *
     * @param sourceNumber
     * @return
     */
    private static byte[] getNetworkBytesOrder(int sourceNumber) {
        byte[] orderBytes = new byte[4];

        orderBytes[3] = (byte) (sourceNumber & 0xFF);
        orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
        orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
        orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);

        return orderBytes;
    }

    /**
     * 还原4个字节的网络字节序
     *
     * @param orderBytes
     * @return
     */
    private static int recoverNetworkBytesOrder(byte[] orderBytes) {
        int sourceNumber = 0;

        for (int i = 0; i < 4; i++) {
            sourceNumber <<= 8;
            sourceNumber |= orderBytes[i] & 0xff;
        }

        return sourceNumber;
    }
}