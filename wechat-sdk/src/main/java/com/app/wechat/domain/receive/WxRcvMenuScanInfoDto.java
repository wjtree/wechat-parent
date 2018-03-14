package com.app.wechat.domain.receive;

import com.app.wechat.domain.WxObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：自定义菜单点击推事件-二维码信息数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 下午6:08:12</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxRcvMenuScanInfoDto extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 扫描类型，一般是qrcode
     */
    @XStreamAlias("ScanType")
    private String scanType;

    /**
     * 扫描结果，即二维码对应的字符串信息
     */
    @XStreamAlias("ScanResult")
    private String scanResult;

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    public String getScanResult() {
        return scanResult;
    }

    public void setScanResult(String scanResult) {
        this.scanResult = scanResult;
    }
}