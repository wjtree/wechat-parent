package com.app.wechat.domain.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：微信公众平台接收普通地理位置消息API数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月13日 上午11:59:55</p>
 * @author 王建
 * @version 1.0
 */
public class WxRcvLocMsgDto extends WxRcvMsgDto {
    private static final long serialVersionUID = 1L;

    /** 地理位置维度 */
    @XStreamAlias("Location_X")
    private String locationX;

    /** 地理位置经度 */
    @XStreamAlias("Location_Y")
    private String locationY;

    /** 地图缩放大小 */
    @XStreamAlias("Scale")
    private String scale;

    /** 地理位置信息 */
    @XStreamAlias("Label")
    private String label;

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}