package com.app.wechat.domain.receive;

import com.app.wechat.domain.WxObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * <p>功 能：自定义菜单拍照发图事件-图片信息数据结构</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月7日 下午6:17:27</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxRcvMenuPicInfoDto extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 发送的图片数量
     */
    @XStreamAlias("Count")
    private Integer count;

    /**
     * 图片列表
     */
    @XStreamImplicit(itemFieldName = "PicList")
    private List<WxRcvMenuPicItemDto> picList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<WxRcvMenuPicItemDto> getPicList() {
        return picList;
    }

    public void setPicList(List<WxRcvMenuPicItemDto> picList) {
        this.picList = picList;
    }
}