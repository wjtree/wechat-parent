package com.app.wechat;

import com.app.wechat.internal.code.WxIndustry;
import org.junit.Test;

public class TestBase {
    @Test
    public void test() throws Exception {
        WxIndustry[] values = WxIndustry.values();
        for (WxIndustry value : values) {
            System.out.println(value.getMaster() + "\t\t\t" + value.getSlave() + "\t\t\t" + value.getCode());
        }
    }
}