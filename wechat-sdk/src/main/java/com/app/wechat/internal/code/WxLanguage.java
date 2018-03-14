package com.app.wechat.internal.code;

/**
 * <p>功 能：微信公众号语言信息枚举</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午4:15:17</p>
 *
 * @author 王建
 * @version 1.0
 */
public enum WxLanguage {
    /**
     * 简体中文
     */
    CN("zh_CN", "简体中文"), /**
     * 繁体中文TW
     */
    TW("zh_TW", "繁体中文TW"), /**
     * 繁体中文HK
     */
    HK("zh_HK", "繁体中文HK"), /**
     * 英文
     */
    EN("en", "英文"), /**
     * 印尼
     */
    ID("id", "印尼"), /**
     * 马来
     */
    MS("ms", "马来"), /**
     * 西班牙
     */
    ES("es", "西班牙"), /**
     * 韩国
     */
    KO("ko", "韩国"), /**
     * 意大利
     */
    IT("it", "意大利"), /**
     * 日本
     */
    JA("ja", "日本"), /**
     * 波兰
     */
    PL("pl", "波兰"), /**
     * 葡萄牙
     */
    PT("pt", "葡萄牙"), /**
     * 俄国
     */
    RU("ru", "俄国"), /**
     * 泰文
     */
    TH("th", "泰文"), /**
     * 越南
     */
    VI("vi", "越南"), /**
     * 阿拉伯语
     */
    AR("ar", "阿拉伯语"), /**
     * 北印度
     */
    HI("hi", "北印度"), /**
     * 希伯来
     */
    HE("he", "希伯来"), /**
     * 土耳其
     */
    TR("tr", "土耳其"), /**
     * 德语
     */
    DE("de", "德语"), /**
     * 法语
     */
    FR("fr", "法语");

    /**
     * 语言类型标识
     */
    private String lang;

    /**
     * 语言类型说明
     */
    private String remark;

    WxLanguage(String lang, String remark) {
        this.lang = lang;
        this.remark = remark;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}