package com.app.wechat.domain.menu;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.WxObject;

/**
 * <p>功 能：个性化菜单-菜单匹配规则</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 上午9:24:41</p>
 * <p>请注意：</p>
 * <ul>
 * <li>matchrule共六个字段，均可为空，但不能全部为空，至少要有一个匹配信息是不为空的</li>
 * <li>country、province、city组成地区信息，将按照country、province、city的顺序进行验证，要符合地区信息表的内容</li>
 * <li>地区信息从大到小验证，小的可以不填，即若填写了省份信息，则国家信息也必填并且匹配，城市信息可以不填</li>
 * <li>例如 “中国 广东省 广州市”、“中国 广东省”都是合法的地域信息，而“中国 广州市”则不合法，因为填写了城市信息但没有填写省份信息。</li>
 * </ul>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCondMenuRuleModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 用户标签的id，可通过用户标签管理接口获取
     */
    @JSONField(name = "tag_id")
    private String tagId;

    /**
     * 性别：男（1）女（2），不填则不做匹配
     * {@link com.app.wechat.internal.code.WxSex}
     */
    private String sex;

    /**
     * 客户端版本，当前只具体到系统型号：IOS(1), Android(2), Others(3)，不填则不做匹配
     * {@link com.app.wechat.internal.code.WxClientPlatformType}
     */
    @JSONField(name = "client_platform_type")
    private String clientPlatformType;

    /**
     * 国家信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String country;

    /**
     * 省份信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String province;

    /**
     * 城市信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String city;

    /**
     * 语言信息，是用户在微信中设置的语言，具体请参考语言表
     * {@link com.app.wechat.internal.code.WxLanguage}
     */
    private String language;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClientPlatformType() {
        return clientPlatformType;
    }

    public void setClientPlatformType(String clientPlatformType) {
        this.clientPlatformType = clientPlatformType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}