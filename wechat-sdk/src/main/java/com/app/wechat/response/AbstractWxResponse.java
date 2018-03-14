package com.app.wechat.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.app.wechat.internal.util.WxUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * <p>功 能：微信公众平台API请求响应基础消息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年6月14日 上午10:16:49</p>
 *
 * @author 王建
 * @version 1.0
 */
public abstract class AbstractWxResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    @JSONField(name = "errcode")
    private String errCode;

    /**
     * 错误信息
     */
    @JSONField(name = "errmsg")
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    /**
     * 根据枚举，将返回码中的英文说明转换为中文说明
     *
     * @param errMsg
     */
    public void setErrMsg(String errMsg) {
        // 将接口返回码的英文提示转换为枚举中的中文说明
        String zhMsg = null;
        if (StringUtils.isNotBlank(errCode))
            zhMsg = WxUtil.getWxCodeMsg(errCode);

        // 如果转换后的中文说明不为空，则使用该中文说明，否则使用原始的说明
        this.errMsg = StringUtils.isNotBlank(zhMsg) ? zhMsg : errMsg;
    }
}