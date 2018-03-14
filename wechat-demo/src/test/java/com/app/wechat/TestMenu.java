package com.app.wechat;

import com.alibaba.fastjson.JSONObject;
import com.app.wechat.code.WxConstant;
import com.app.wechat.core.DefaultWxClient;
import com.app.wechat.core.WxClient;
import com.app.wechat.domain.menu.WxCondMenuModel;
import com.app.wechat.domain.menu.WxMenuModel;
import com.app.wechat.domain.menu.WxSubMenuModel;
import com.app.wechat.internal.code.WxSex;
import com.app.wechat.internal.util.WxMenuUtil;
import com.app.wechat.request.*;
import org.junit.Test;

/**
 * <p>功 能：微信公众号菜单API测试类</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年7月8日 下午5:35:12</p>
 *
 * @author 王建
 * @version 1.0
 */
public class TestMenu {
    WxClient client = new DefaultWxClient(WxConstant.APP_ID, WxConstant.APP_SECRET);

    @Test
    public void createMenu() {
        try {
            // 子菜单一
            WxSubMenuModel butt11 = WxMenuUtil.loadClickMenuAttr("click", "点击推事件 click");
            WxSubMenuModel butt12 = WxMenuUtil.loadViewMenuAttr("view", "http://m.baidu.com");
            WxSubMenuModel butt13 = WxMenuUtil.loadScanCodePushMenuAttr("scancode_push", "扫码推事件 scancode_push");
            WxSubMenuModel butt14 = WxMenuUtil.loadScanCodeWaitMsgMenuAttr("scancode_waitmsg", "扫码推事件且弹出“消息接收中”提示框 scancode_waitmsg");
            WxSubMenuModel butt15 = WxMenuUtil.loadPicSysPhotoMenuAttr("pic_sysphoto", "弹出系统拍照发图 pic_sysphoto");
            WxSubMenuModel subButt1 = WxMenuUtil.getWxSubMenuModel("主菜单1", butt11, butt12, butt13, butt14, butt15);

            // 子菜单二
            WxSubMenuModel butt21 = WxMenuUtil.loadPicPhotoOrAlbumMenuAttr("pic_photo_or_album", "弹出拍照或者相册发图 pic_photo_or_album");
            WxSubMenuModel butt22 = WxMenuUtil.loadPicWeiXinMenuAttr("pic_weixin", "弹出微信相册发图器 pic_weixin");
            WxSubMenuModel butt23 = WxMenuUtil.loadLocationSelectMenuAttr("location_select", "弹出地理位置选择器 location_select");
            WxSubMenuModel butt24 = WxMenuUtil.loadViewMenuAttr("子菜单24", "http://m.baidu.com");
            WxSubMenuModel butt25 = WxMenuUtil.loadViewMenuAttr("子菜单25", "http://m.baidu.com");
            WxSubMenuModel subButt2 = WxMenuUtil.getWxSubMenuModel("主菜单2", butt21, butt22, butt23, butt24, butt25);

            // 子菜单三
            WxSubMenuModel butt31 = WxMenuUtil.loadViewMenuAttr("子菜单31", "http://m.baidu.com");
            WxSubMenuModel butt32 = WxMenuUtil.loadViewMenuAttr("子菜单32", "http://m.baidu.com");
            WxSubMenuModel butt33 = WxMenuUtil.loadViewMenuAttr("子菜单33", "http://m.baidu.com");
            WxSubMenuModel butt34 = WxMenuUtil.loadViewMenuAttr("子菜单34", "http://m.baidu.com");
            WxSubMenuModel butt35 = WxMenuUtil.loadViewMenuAttr("子菜单35", "http://m.baidu.com");
            WxSubMenuModel subButt3 = WxMenuUtil.getWxSubMenuModel("主菜单3", butt31, butt32, butt33, butt34, butt35);

            // 组装菜单
            WxMenuModel bizModel = WxMenuUtil.getWxMenuModel(subButt1, subButt2, subButt3);

            WxMenuCreateRequest req = new WxMenuCreateRequest(bizModel);

            client.execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createCondMenu() {
        try {
            // 子菜单一
            WxSubMenuModel butt11 = WxMenuUtil.loadClickMenuAttr("男士专用", "点击推事件 click");

            // 子菜单二
            WxSubMenuModel butt21 = WxMenuUtil.loadPicPhotoOrAlbumMenuAttr("pic_photo_or_album", "弹出拍照或者相册发图 pic_photo_or_album");
            WxSubMenuModel butt22 = WxMenuUtil.loadPicWeiXinMenuAttr("pic_weixin", "弹出微信相册发图器 pic_weixin");
            WxSubMenuModel butt23 = WxMenuUtil.loadLocationSelectMenuAttr("location_select", "弹出地理位置选择器 location_select");
            WxSubMenuModel butt24 = WxMenuUtil.loadViewMenuAttr("子菜单24", "http://m.baidu.com");
            WxSubMenuModel butt25 = WxMenuUtil.loadViewMenuAttr("子菜单25", "http://m.baidu.com");
            WxSubMenuModel subButt2 = WxMenuUtil.getWxSubMenuModel("主菜单2", butt21, butt22, butt23, butt24, butt25);

            // 组装菜单
            WxCondMenuModel bizModel = WxMenuUtil.getWxCondMenuModel(WxSex.MALE, butt11, subButt2);

            WxCondMenuCreateRequest req = new WxCondMenuCreateRequest(bizModel);

            client.execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMenu() throws Exception {
        WxMenuGetRequest req = new WxMenuGetRequest();

        client.execute(req);
    }

    @Test
    public void getSelfMenu() throws Exception {
        WxSelfMenuGetRequest req = new WxSelfMenuGetRequest();

        client.execute(req);
    }

    @Test
    public void delMenu() throws Exception {
        WxMenuDelRequest req = new WxMenuDelRequest();

        client.execute(req);
    }

    @Test
    public void delCondMenu() throws Exception {
        WxMenuModel model = WxMenuUtil.getWxMenuModel("406874797");

        WxCondMenuDelRequest req = new WxCondMenuDelRequest(model);

        client.execute(req);
    }

    @Test
    public void matchCondMenu() throws Exception {
        JSONObject model = new JSONObject();
        model.put("user_id", "oX_DYt3AiupzsygSGIcqzw-l6NNo");

        WxCondMenuMatchRequest req = new WxCondMenuMatchRequest(model);

        client.execute(req);
    }

    @Test
    public void get() {
        try {
            // WxBackIpRequest req = new WxBackIpRequest();
            WxClearQuotaRequest req = new WxClearQuotaRequest(WxConstant.APP_ID);

            client.execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}