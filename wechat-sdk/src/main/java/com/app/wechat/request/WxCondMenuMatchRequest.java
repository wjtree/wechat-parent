/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.request;

import com.alibaba.fastjson.JSONObject;
import com.app.wechat.internal.code.HttpMethod;
import com.app.wechat.internal.code.WxUrl;
import com.app.wechat.response.WxCondMenuMatchResponse;

/**
 * <p>功 能：测试匹配个性化菜单API的请求信息</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月6日 下午6:53:48</p>
 * <p>
 * <p>开发者可以通过以下条件来设置用户看到的菜单：</p>
 * <ol>
 * <li>用户标签（开发者的业务需求可以借助用户标签来完成）</li>
 * <li>性别</li>
 * <li>手机操作系统</li>
 * <li>地区（用户在微信客户端设置的地区）</li>
 * <li>语言（用户在微信客户端设置的语言）</li>
 * </ol>
 * <p>个性化菜单接口说明：</p>
 * <ol>
 * <li>个性化菜单要求用户的微信客户端版本在iPhone6.2.2，Android 6.2.4以上，暂时不支持其他版本微信</li>
 * <li>菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果</li>
 * <li>普通公众号的个性化菜单的新增接口每日限制次数为2000次，删除接口也是2000次，测试个性化菜单匹配结果接口为20000次</li>
 * <li>出于安全考虑，一个公众号的所有个性化菜单，最多只能设置为跳转到3个域名下的链接</li>
 * <li>创建个性化菜单之前必须先创建默认菜单（默认菜单是指使用普通自定义菜单创建接口创建的菜单）。如果删除默认菜单，个性化菜单也会全部删除</li>
 * <li>个性化菜单接口支持用户标签，请开发者注意，当用户身上的标签超过1个时，以最后打上的标签为匹配</li>
 * </ol>
 * <p>个性化菜单匹配规则说明：</p>
 * <ul>
 * <li>个性化菜单的更新是会被覆盖的</li>
 * <li>例如公众号先后发布了默认菜单，个性化菜单1，个性化菜单2，个性化菜单3。那么当用户进入公众号页面时，将从个性化菜单3开始匹配，如果个性化菜单3匹配成功，则直接返回个性化菜单3，否则继续尝试匹配个性化菜单2，直到成功匹配到一个菜单</li>
 * <li>根据上述匹配规则，为了避免菜单生效时间的混淆，决定不予提供个性化菜单编辑API，开发者需要更新菜单时，需将完整配置重新发布一轮</li>
 * </ul>
 *
 * @author 王建
 * @version 1.0
 */
public class WxCondMenuMatchRequest extends AbstractWxRequest<WxCondMenuMatchResponse> {
    private static final long serialVersionUID = 1L;

    private JSONObject object;

    public WxCondMenuMatchRequest(JSONObject object) {
        this.object = object;
    }

    public JSONObject getObject() {
        return object;
    }

    public Class<WxCondMenuMatchResponse> getResponseClass() {
        return WxCondMenuMatchResponse.class;
    }

    public String getUrl(String accessToken) {
        return String.format(WxUrl.API_MENU_TRYMATCH, accessToken);
    }

    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}