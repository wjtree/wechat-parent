package com.app.wechat.internal.code;

/**
 * <p>功 能：微信公众号平台API接口地址</p>
 * <p>版 权：Copyright (c) 2017</p>
 * <p>创建时间：2017年5月8日 上午10:26:02</p>
 *
 * @author 王建
 * @version 1.0
 */
public class WxUrl {
    /**
     * 公众号平台网页授权接口域名
     */
    public static final String WX_OAUTH_DOMAIN = "https://open.weixin.qq.com/";

    /**
     * 公众号平台接口通用域名
     */
    public static final String WX_SERVER_DOMAIN = "https://api.weixin.qq.com/";
    /**
     * 公众号平台接口上海域名
     */
    public static final String WX_SERVER_SH_DOMAIN = "https://sh.api.weixin.qq.com/";
    /**
     * 公众号平台接口深圳域名
     */
    public static final String WX_SERVER_SZ_DOMAIN = "https://sz.api.weixin.qq.com/";
    /**
     * 公众号平台接口香港域名
     */
    public static final String WX_SERVER_HK_DOMAIN = "https://hk.api.weixin.qq.com/";

    /**
     * 此方法用于自动获取与当前用户公众号服务器连接最快的微信服务器域名，待完善
     *
     * @return
     */
    private static String getDomain() {
        return WX_SERVER_DOMAIN;
    }

    /**
     * 接口名称：对话服务-基础支持-获取access_token <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_ACCESS_TOKEN = getDomain() + "cgi-bin/token?grant_type=client_credential&appid=%1$s&secret=%2$s";
    /**
     * 接口名称：对话服务-基础支持-获取微信服务器IP地址 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_CALL_BACK_IP = getDomain() + "cgi-bin/getcallbackip?access_token=%s";
    /**
     * 接口名称：对话服务-基础支持-API调用次数清零 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_CLEAR_QUOTA = getDomain() + "cgi-bin/clear_quota?access_token=%s";

    /**
     * 接口名称：对话服务-发送消息-自动回复-获取公众号的自动回复规则 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_GET_CURRENT_AUTOREPLY_INFO = getDomain() + "cgi-bin/get_current_autoreply_info?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-客服接口-发消息 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MESSAGE_CUSTOM_SEND = getDomain() + "cgi-bin/message/custom/send?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-客服接口-客服输入状态 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MESSAGE_CUSTOM_TYPING = getDomain() + "cgi-bin/message/custom/typing?access_token=%s";

    /**
     * 接口名称：对话服务-发送消息-群发接口-根据标签进行群发 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MESSAGE_MASS_SENDALL = getDomain() + "cgi-bin/message/mass/sendall?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-群发接口-根据OpenID列表群发 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MESSAGE_MASS_SEND = getDomain() + "cgi-bin/message/mass/send?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-群发接口-删除群发 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MESSAGE_MASS_DELETE = getDomain() + "cgi-bin/message/mass/delete?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-群发接口-预览接口 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MESSAGE_MASS_PREVIEW = getDomain() + "cgi-bin/message/mass/preview?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-群发接口-查询群发消息发送状态 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MESSAGE_MASS_GET = getDomain() + "cgi-bin/message/mass/get?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-群发接口-获取群发速度 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MESSAGE_MASS_SPEED_GET = getDomain() + "cgi-bin/message/mass/speed/get?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-群发接口-设置群发速度 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MESSAGE_MASS_SPEED_SET = getDomain() + "cgi-bin/message/mass/speed/set?access_token=%s";

    /**
     * 接口名称：对话服务-发送消息-模板消息-设置所属行业 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TEMPLATE_SET_INDUSTRY = getDomain() + "cgi-bin/template/api_set_industry?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-模板消息-获取设置的行业信息 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_TEMPLATE_GET_INDUSTRY = getDomain() + "cgi-bin/template/get_industry?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-模板消息-获得模板ID <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TEMPLATE_ADD_TEMPLATE = getDomain() + "cgi-bin/template/api_add_template?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-模板消息-获取模板列表 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_TEMPLATE_GET_TEMPLATE = getDomain() + "cgi-bin/template/get_all_private_template?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-模板消息-删除模板 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TEMPLATE_DEL_TEMPLATE = getDomain() + "cgi-bin/template/del_private_template?access_token=%s";
    /**
     * 接口名称：对话服务-发送消息-模板消息-发送模板消息 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TEMPLATE_SEND = getDomain() + "cgi-bin/message/template/send?access_token=%s";

    /**
     * 接口名称：对话服务-用户管理-用户分组管理-标签管理-创建标签 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TAGS_CREATE = getDomain() + "cgi-bin/tags/create?access_token=%s";
    /**
     * 接口名称：对话服务-用户管理-用户分组管理-标签管理-获取公众号已创建的标签 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_TAGS_GET = getDomain() + "cgi-bin/tags/get?access_token=%s";
    /**
     * 接口名称：对话服务-用户管理-用户分组管理-标签管理-编辑标签 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TAGS_UPDATE = getDomain() + "cgi-bin/tags/update?access_token=%s";
    /**
     * 接口名称：对话服务-用户管理-用户分组管理-标签管理-删除标签 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TAGS_DELETE = getDomain() + "cgi-bin/tags/delete?access_token=%s";
    /**
     * 接口名称：对话服务-用户管理-用户分组管理-标签管理-获取标签下粉丝列表 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TAGS_GET_USER = getDomain() + "cgi-bin/user/tag/get?access_token=%s";
    /**
     * 接口名称：对话服务-用户管理-用户分组管理-标签管理-批量为用户打标签 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TAGS_MEMBERS_BATCHTAGGING = getDomain() + "cgi-bin/tags/members/batchtagging?access_token=%s";
    /**
     * 接口名称：对话服务-用户管理-用户分组管理-标签管理-批量为用户取消标签 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TAGS_MEMBERS_BATCHUNTAGGING = getDomain() + "cgi-bin/tags/members/batchuntagging?access_token=%s";
    /**
     * 接口名称：对话服务-用户管理-用户分组管理-标签管理-获取用户身上的标签列表 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TAGS_MEMBERS_GETIDLIST = getDomain() + "cgi-bin/tags/getidlist?access_token=%s";

    /**
     * 接口名称：对话服务-用户管理-用户分组管理-黑名单管理-获取公众号的黑名单列表 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TAGS_MEMBERS_GETBLACKLIST = getDomain() + "cgi-bin/tags/members/getblacklist?access_token=%s";
    /**
     * 接口名称：对话服务-用户管理-用户分组管理-黑名单管理-拉黑用户 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TAGS_MEMBERS_BATCHBLACKLIST = getDomain() + "cgi-bin/tags/members/batchblacklist?access_token=%s";
    /**
     * 接口名称：对话服务-用户管理-用户分组管理-黑名单管理-取消拉黑用户 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_TAGS_MEMBERS_BATCHUNBLACKLIST = getDomain() + "cgi-bin/tags/members/batchunblacklist?access_token=%s";

    /**
     * 接口名称：对话服务-用户管理-设置用户备注名 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_USER_INFO_UPDATEREMARK = getDomain() + "cgi-bin/user/info/updateremark?access_token=%s";
    /**
     * 接口名称：对话服务-用户管理-获取用户基本信息 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_USER_INFO = getDomain() + "cgi-bin/user/info?access_token=%1$s&openid=%2$s&lang=zh_CN";
    /**
     * 接口名称：对话服务-用户管理-批量获取用户基本信息 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_USER_INFO_BATCHGET = getDomain() + "cgi-bin/user/info/batchget?access_token=%s";
    /**
     * 接口名称：对话服务-用户管理-获取用户列表 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_USER_GET = getDomain() + "cgi-bin/user/get?access_token=%1$s&next_openid=%2$s";

    /**
     * 接口名称：对话服务-推广支持-生成带参数二维码-创建二维码ticket <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_QRCODE_CREATE = getDomain() + "cgi-bin/qrcode/create?access_token=%s";
    /**
     * 接口名称：对话服务-推广支持-生成带参数二维码-通过ticket换取二维码 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_SHOW_QRCODE = getDomain() + "cgi-bin/showqrcode?ticket=%s";
    /**
     * 接口名称：对话服务-推广支持-长链接转短链接接口 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_SHORT_URL = getDomain() + "cgi-bin/shorturl?access_token=%s";

    /**
     * 接口名称：对话服务-界面丰富-自定义菜单-自定义菜单创建接口 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MENU_CREATE = getDomain() + "cgi-bin/menu/create?access_token=%s";
    /**
     * 接口名称：对话服务-界面丰富-自定义菜单-自定义菜单查询接口 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_MENU_GET = getDomain() + "cgi-bin/menu/get?access_token=%s";
    /**
     * 接口名称：对话服务-界面丰富-自定义菜单-自定义菜单删除接口 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_MENU_DELETE = getDomain() + "cgi-bin/menu/delete?access_token=%s";
    /**
     * 接口名称：对话服务-界面丰富-自定义菜单-创建个性化菜单 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MENU_ADDCONDITIONAL = getDomain() + "cgi-bin/menu/addconditional?access_token=%s";
    /**
     * 接口名称：对话服务-界面丰富-自定义菜单-删除个性化菜单 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MENU_DELCONDITIONAL = getDomain() + "cgi-bin/menu/delconditional?access_token=%s";
    /**
     * 接口名称：对话服务-界面丰富-自定义菜单-测试个性化菜单匹配结果 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MENU_TRYMATCH = getDomain() + "cgi-bin/menu/trymatch?access_token=%s";
    /**
     * 接口名称：对话服务-界面丰富-自定义菜单-获取自定义菜单配置接口 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_GET_CURRENT_SELFMENU_INFO = getDomain() + "cgi-bin/get_current_selfmenu_info?access_token=%s";

    /**
     * 接口名称：对话服务-素材管理-上传下载多媒体 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MEDIA_UPLOADVIDEO = getDomain() + "cgi-bin/media/uploadvideo?access_token=%s";
    /**
     * 接口名称：对话服务-素材管理-上传图文消息内的图片获取URL <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MEDIA_UPLOADIMG = getDomain() + "cgi-bin/media/uploadimg?access_token=%s";
    /**
     * 接口名称：对话服务-素材管理-上传图文消息素材 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MEDIA_UPLOADNEWS = getDomain() + "cgi-bin/media/uploadnews?access_token=%s";
    /**
     * 接口名称：对话服务-素材管理-新增临时素材 <br/>
     * 请求方式：HTTPS POST/FORM
     */
    public static final String API_MEDIA_UPLOAD = getDomain() + "cgi-bin/media/upload?access_token=%1$s&type=%2$s";
    /**
     * 接口名称：对话服务-素材管理-获取临时素材 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_MEDIA_GET = getDomain() + "cgi-bin/media/get?access_token=%1$s&media_id=%2$s";
    /**
     * 接口名称：对话服务-素材管理-高清语音素材获取接口 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_MEDIA_GET_JSSDK = getDomain() + "cgi-bin/media/get/jssdk?access_token=%1$s&media_id=%2$s";
    /**
     * 接口名称：对话服务-素材管理-新增永久图文素材 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MATERIAL_ADD_NEWS = getDomain() + "cgi-bin/material/add_news?access_token=%s";
    /**
     * 接口名称：对话服务-素材管理-新增其他类型永久素材 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MATERIAL_ADD_MATERIAL = getDomain() + "cgi-bin/material/add_material?access_token=%1$s&type=%2$s";
    /**
     * 接口名称：对话服务-素材管理-获取永久素材 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MATERIAL_GET = getDomain() + "cgi-bin/material/get_material?access_token=%s";
    /**
     * 接口名称：对话服务-素材管理-删除永久素材 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MATERIAL_DEL = getDomain() + "cgi-bin/material/del_material?access_token=%s";
    /**
     * 接口名称：对话服务-素材管理-修改永久图文素材 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MATERIAL_UPDATE_NEWS = getDomain() + "cgi-bin/material/update_news?access_token=%s";
    /**
     * 接口名称：对话服务-素材管理-获取素材总数 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_MATERIAL_COUNT = getDomain() + "cgi-bin/material/get_materialcount?access_token=%s";
    /**
     * 接口名称：对话服务-素材管理-获取素材列表 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_MATERIAL_BATCHGET = getDomain() + "cgi-bin/material/batchget_material?access_token=%s";

    /**
     * 接口名称：对话服务-图文消息留言管理-打开已群发文章评论 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_COMMENT_OPEN = getDomain() + "cgi-bin/comment/open?access_token=%s";
    /**
     * 接口名称：对话服务-图文消息留言管理-关闭已群发文章评论 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_COMMENT_CLOSE = getDomain() + "cgi-bin/comment/close?access_token=%s";
    /**
     * 接口名称：对话服务-图文消息留言管理-查看指定文章的评论数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_COMMENT_LIST = getDomain() + "cgi-bin/comment/list?access_token=%s";
    /**
     * 接口名称：对话服务-图文消息留言管理-将评论标记精选 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_COMMENT_MARKELECT = getDomain() + "cgi-bin/comment/markelect?access_token=%s";
    /**
     * 接口名称：对话服务-图文消息留言管理-将评论取消精选 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_COMMENT_UNMARKELECT = getDomain() + "cgi-bin/comment/unmarkelect?access_token=%s";
    /**
     * 接口名称：对话服务-图文消息留言管理-删除评论 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_COMMENT_DELETE = getDomain() + "cgi-bin/comment/delete?access_token=%s";
    /**
     * 接口名称：对话服务-图文消息留言管理-回复评论 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_COMMENT_REPLY_ADD = getDomain() + "cgi-bin/comment/reply/add?access_token=%s";
    /**
     * 接口名称：对话服务-图文消息留言管理-删除回复 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_COMMENT_REPLY_DELETE = getDomain() + "cgi-bin/comment/reply/delete?access_token=%s";

    /**
     * 接口名称：功能服务-多客服-客服管理-添加客服帐号 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_CUSTOMSERVICE_KFACCOUNT_ADD = getDomain() + "customservice/kfaccount/add?access_token=%s";
    /**
     * 接口名称：功能服务-多客服-客服管理-邀请绑定客服帐号 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_CUSTOMSERVICE_KFACCOUNT_INVITEWORKER = getDomain() + "customservice/kfaccount/inviteworker?access_token=%s";
    /**
     * 接口名称：功能服务-多客服-客服管理-修改客服帐号 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_CUSTOMSERVICE_KFACCOUNT_UPDATE = getDomain() + "customservice/kfaccount/update?access_token=%s";
    /**
     * 接口名称：功能服务-多客服-客服管理-删除客服帐号 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_CUSTOMSERVICE_KFACCOUNT_DEL = getDomain() + "customservice/kfaccount/del?access_token=%s";
    /**
     * 接口名称：功能服务-多客服-客服管理-设置客服帐号的头像 <br/>
     * 请求方式：HTTP POST/FORM
     */
    public static final String API_CUSTOMSERVICE_KFACCOUNT_UPLOADHEADIMG = getDomain() + "customservice/kfaccount/uploadheadimg?access_token=%1$s&kf_account=%2$s";
    /**
     * 接口名称：功能服务-多客服-客服管理-获取所有客服账号 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_CUSTOMSERVICE_GETKFLIST = getDomain() + "cgi-bin/customservice/getkflist?access_token=%s";
    /**
     * 接口名称：功能服务-多客服-客服管理-获取所有在线的客服账号 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_CUSTOMSERVICE_GETONLINEKFLIST = getDomain() + "cgi-bin/customservice/getonlinekflist?access_token=%s";

    /**
     * 接口名称：网页服务-网页授权-获取code <br/>
     * 请求方式：浏览器打开此授权页面链接获取code
     */
    public static final String API_OAUTH_CODE = WX_OAUTH_DOMAIN + "connect/oauth2/authorize?appid=%1$s&redirect_uri=%2$s&response_type=code&scope=%3$s&state=%4$s#wechat_redirect";
    /**
     * 接口名称：网页服务-网页授权-通过code换取网页授权access_token <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_OAUTH_ACCESS_TOKEN = getDomain() + "sns/oauth2/access_token?appid=%1$s&secret=%2$s&code=%3$s&grant_type=authorization_code";
    /**
     * 接口名称：网页服务-网页授权-刷新access_token <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_OAUTH_REFRESH_TOKEN = getDomain() + "sns/oauth2/refresh_token?appid=%1$s&grant_type=refresh_token&refresh_token=%2$s";
    /**
     * 接口名称：网页服务-网页授权-检验授权凭证（access_token）是否有效 <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_OAUTH_ACCESS_TOKEN_CHECK = getDomain() + "sns/auth?access_token=%1$s&openid=%2$s";
    /**
     * 接口名称：网页服务-网页授权-拉取用户信息(需scope为 snsapi_userinfo) <br/>
     * 请求方式：HTTPS GET
     */
    public static final String API_OAUTH_USERINFO = getDomain() + "sns/userinfo?access_token=%1$s&openid=%2$s&lang=zh_CN";

    /**
     * 接口名称：数据统计-用户分析数据接口-获取用户增减数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUSERSUMMARY = getDomain() + "datacube/getusersummary?access_token=%s";
    /**
     * 接口名称：数据统计-用户分析数据接口-获取累计用户数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUSERCUMULATE = getDomain() + "datacube/getusercumulate?access_token=%s";

    /**
     * 接口名称：数据统计-图文分析数据接口-获取图文群发每日数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETARTICLESUMMARY = getDomain() + "datacube/getarticlesummary?access_token=%s";
    /**
     * 接口名称：数据统计-图文分析数据接口-获取图文群发总数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETARTICLETOTAL = getDomain() + "datacube/getarticletotal?access_token=%s";
    /**
     * 接口名称：数据统计-图文分析数据接口-获取图文统计数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUSERREAD = getDomain() + "datacube/getuserread?access_token=%s";
    /**
     * 接口名称：数据统计-图文分析数据接口-获取图文统计分时数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUSERREADHOUR = getDomain() + "datacube/getuserreadhour?access_token=%s";
    /**
     * 接口名称：数据统计-图文分析数据接口-获取图文分享转发数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUSERSHARE = getDomain() + "datacube/getusershare?access_token=%s";
    /**
     * 接口名称：数据统计-图文分析数据接口-获取图文分享转发分时数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUSERSHAREHOUR = getDomain() + "datacube/getusersharehour?access_token=%s";

    /**
     * 接口名称：数据统计-消息分析数据接口-获取消息发送概况数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUPSTREAMMSG = getDomain() + "datacube/getupstreammsg?access_token=%s";
    /**
     * 接口名称：数据统计-消息分析数据接口-获取消息分送分时数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUPSTREAMMSGHOUR = getDomain() + "datacube/getupstreammsghour?access_token=%s";
    /**
     * 接口名称：数据统计-消息分析数据接口-获取消息发送周数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUPSTREAMMSGWEEK = getDomain() + "datacube/getupstreammsgweek?access_token=%s";
    /**
     * 接口名称：数据统计-消息分析数据接口-获取消息发送月数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUPSTREAMMSGMONTH = getDomain() + "datacube/getupstreammsgmonth?access_token=%s";
    /**
     * 接口名称：数据统计-消息分析数据接口-获取消息发送分布数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUPSTREAMMSGDIST = getDomain() + "datacube/getupstreammsgdist?access_token=%s";
    /**
     * 接口名称：数据统计-消息分析数据接口-获取消息发送分布周数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUPSTREAMMSGDISTWEEK = getDomain() + "datacube/getupstreammsgdistweek?access_token=%s";
    /**
     * 接口名称：数据统计-消息分析数据接口-获取消息发送分布月数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETUPSTREAMMSGDISTMONTH = getDomain() + "datacube/getupstreammsgdistmonth?access_token=%s";

    /**
     * 接口名称：数据统计-接口分析数据接口-获取接口分析数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETINTERFACESUMMARY = getDomain() + "datacube/getinterfacesummary?access_token=%s";
    /**
     * 接口名称：数据统计-接口分析数据接口-获取接口分析分时数据 <br/>
     * 请求方式：HTTPS POST
     */
    public static final String API_DATACUBE_GETINTERFACESUMMARYHOUR = getDomain() + "datacube/getinterfacesummaryhour?access_token=%s";
}