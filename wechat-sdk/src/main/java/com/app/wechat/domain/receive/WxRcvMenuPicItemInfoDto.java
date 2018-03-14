package com.app.wechat.domain.receive;

import com.app.wechat.domain.WxObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>功 能：自定义菜单拍照发图事件-图片信息数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 下午6:17:27</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxRcvMenuPicItemInfoDto extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 图片的MD5值，开发者若需要，可用于验证接收到图片
     */
    @XStreamAlias("PicMd5Sum")
    private String picMd5Sum;

    public String getPicMd5Sum() {
        return picMd5Sum;
    }

    public void setPicMd5Sum(String picMd5Sum) {
        this.picMd5Sum = picMd5Sum;
    }
}