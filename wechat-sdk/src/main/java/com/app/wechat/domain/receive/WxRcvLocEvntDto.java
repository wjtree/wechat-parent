package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收上报地理位置事件推送API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 下午2:36:21</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvLocEvntDto extends WxRcvEvntDto {
    private static final long serialVersionUID = 1L;

    /** 地理位置纬度 */
    @XStreamAlias("Latitude")
    private String latitude;

    /** 地理位置经度 */
    @XStreamAlias("Longitude")
    private String longitude;

    /** 地理位置精度 */
    @XStreamAlias("Precision")
    private String precision;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}