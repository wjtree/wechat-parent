/**
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.app.wechat.internal.code;

/**
 * 微信公众平台模版消息的行业枚举
 *
 * @author wjtree
 * @version 1.0
 */
public enum WxIndustry {
    /**
     * IT科技-互联网/电子商务
     */
    I1("1", "IT科技", "互联网/电子商务"), /**
     * IT科技-IT软件与服务
     */
    I2("2", "IT科技", "IT软件与服务"), /**
     * IT科技-IT硬件与设备
     */
    I3("3", "IT科技", "IT硬件与设备"), /**
     * IT科技-电子技术
     */
    I4("4", "IT科技", "电子技术"), /**
     * IT科技-通信与运营商
     */
    I5("5", "IT科技", "通信与运营商"), /**
     * IT科技-网络游戏
     */
    I6("6", "IT科技", "网络游戏"), /**
     * 金融业-银行
     */
    I7("7", "金融业", "银行"), /**
     * 金融业-基金|理财|信托
     */
    I8("8", "金融业", "基金|理财|信托"), /**
     * 金融业-保险
     */
    I9("9", "金融业", "保险"), /**
     * 餐饮-餐饮
     */
    I10("10", "餐饮", "餐饮"), /**
     * 酒店旅游-酒店
     */
    I11("11", "酒店旅游", "酒店"), /**
     * 酒店旅游-旅游
     */
    I12("12", "酒店旅游", "旅游"), /**
     * 运输与仓储-快递
     */
    I13("13", "运输与仓储", "快递"), /**
     * 运输与仓储-物流
     */
    I14("14", "运输与仓储", "物流"), /**
     * 运输与仓储-仓储
     */
    I15("15", "运输与仓储", "仓储"), /**
     * 教育-培训
     */
    I16("16", "教育", "培训"), /**
     * 教育-院校
     */
    I17("17", "教育", "院校"), /**
     * 政府与公共事业-学术科研
     */
    I18("18", "政府与公共事业", "学术科研"), /**
     * 政府与公共事业-交警
     */
    I19("19", "政府与公共事业", "交警"), /**
     * 政府与公共事业-博物馆
     */
    I20("20", "政府与公共事业", "博物馆"), /**
     * 政府与公共事业-公共事业|非盈利机构
     */
    I21("21", "政府与公共事业", "公共事业|非盈利机构"), /**
     * 医药护理-医药医疗
     */
    I22("22", "医药护理", "医药医疗"), /**
     * 医药护理-护理美容
     */
    I23("23", "医药护理", "护理美容"), /**
     * 医药护理-保健与卫生
     */
    I24("24", "医药护理", "保健与卫生"), /**
     * 交通工具-汽车相关
     */
    I25("25", "交通工具", "汽车相关"), /**
     * 交通工具-摩托车相关
     */
    I26("26", "交通工具", "摩托车相关"), /**
     * 交通工具-火车相关
     */
    I27("27", "交通工具", "火车相关"), /**
     * 交通工具-飞机相关
     */
    I28("28", "交通工具", "飞机相关"), /**
     * 房地产-建筑
     */
    I29("29", "房地产", "建筑"), /**
     * 房地产-物业
     */
    I30("30", "房地产", "物业"), /**
     * 消费品-消费品
     */
    I31("31", "消费品", "消费品"), /**
     * 商业服务-法律
     */
    I32("32", "商业服务", "法律"), /**
     * 商业服务-会展
     */
    I33("33", "商业服务", "会展"), /**
     * 商业服务-中介服务
     */
    I34("34", "商业服务", "中介服务"), /**
     * 商业服务-认证
     */
    I35("35", "商业服务", "认证"), /**
     * 商业服务-审计
     */
    I36("36", "商业服务", "审计"), /**
     * 文体娱乐-传媒
     */
    I37("37", "文体娱乐", "传媒"), /**
     * 文体娱乐-体育
     */
    I38("38", "文体娱乐", "体育"), /**
     * 文体娱乐-娱乐休闲
     */
    I39("39", "文体娱乐", "娱乐休闲"), /**
     * 印刷-印刷
     */
    I40("40", "印刷", "印刷"), /**
     * 其它-其它
     */
    I41("41", "其它", "其它");

    /**
     * 行业代码
     */
    private final String code;
    /**
     * 主行业
     */
    private final String master;
    /**
     * 副行业
     */
    private final String slave;

    WxIndustry(String code, String master, String slave) {
        this.code = code;
        this.master = master;
        this.slave = slave;
    }

    public String getCode() {
        return code;
    }

    public String getMaster() {
        return master;
    }

    public String getSlave() {
        return slave;
    }
}