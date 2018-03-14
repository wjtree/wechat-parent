/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.domain.mass;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.WxObject;

/**
 * 群发消息-根据标签进行群发API
 * 用于设定图文消息的接收者
 *
 * @author wjtree
 * @version 1.0
 */
public class WxMassFilterModel extends WxObject {
    private static final long serialVersionUID = 1L;

    /**
     * 用于设定是否向全部用户发送，值为true或false<br/>
     * 选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
     */
    @JSONField(name = "is_to_all")
    private Boolean isToAll;

    /**
     * 群发到的标签的tag_id，参加用户管理中用户分组接口<br/>
     * 若is_to_all值为true，可不填写tag_id
     */
    @JSONField(name = "tag_id")
    private Short tagId;

    public Boolean getIsToAll() {
        return isToAll;
    }

    public void setIsToAll(Boolean isToAll) {
        this.isToAll = isToAll;
    }

    public Short getTagId() {
        return tagId;
    }

    public void setTagId(Short tagId) {
        this.tagId = tagId;
    }
}