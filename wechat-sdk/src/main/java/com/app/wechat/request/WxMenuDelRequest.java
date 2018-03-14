package com.app.wechat.request;

import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxMenuDelResponse;

/**
 * <p>功 能：自定义菜单删除接口API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 * <p>
 * <p>请注意：</p>
 * <ol>
 * <li>自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单</li>
 * <li>一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替</li>
 * <li>创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，
 * 如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。
 * 测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果</li>
 * </ol>
 *
 * @author 王建
 * @version 1.0
 */
public class WxMenuDelRequest extends AbstractWxRequest<WxMenuDelResponse> {
    private static final long serialVersionUID = 1L;

    public Class<WxMenuDelResponse> getResponseClass() {
        return WxMenuDelResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MENU_DELETE, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }
}