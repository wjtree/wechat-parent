package com.app.wechat.domain.receive;

import com.app.wechat.domain.WxObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：自定义菜单弹出地理位置选择器事件-位置信息数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 下午6:29:40</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxRcvMenuLocInfoDto extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * X坐标信息
     */
    @XStreamAlias("Location_X")
    private String locationX;

    /**
     * Y坐标信息
     */
    @XStreamAlias("Location_Y")
    private String locationY;

    /**
     * 精度，可理解为精度或者比例尺、越精细的话 scale越高
     */
    @XStreamAlias("Scale")
    private String scale;

    /**
     * 地理位置的字符串信息
     */
    @XStreamAlias("Label")
    private String label;

    /**
     * 朋友圈POI的名字，可能为空
     */
    @XStreamAlias("Poiname")
    private String poiName;

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

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }
}