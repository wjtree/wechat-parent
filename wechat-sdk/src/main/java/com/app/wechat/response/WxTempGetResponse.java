/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.domain.WxTempModel;

import java.util.List;

/**
 * <p>功 能：模板消息-获取模板列表API的响应信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月5日 下午3:45:34</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxTempGetResponse extends AbstractWxResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 模版列表
     */
    @JSONField(name = "template_list")
    private List<WxTempModel> templateList;

    public List<WxTempModel> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<WxTempModel> templateList) {
        this.templateList = templateList;
    }
}