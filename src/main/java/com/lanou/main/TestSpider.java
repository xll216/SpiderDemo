package com.lanou.main;

import com.cv4j.netdiscovery.core.Spider;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class TestSpider {

    public static void main(String[] args) {
        //目标任务的网页地址，可以拷贝到浏览器去查看
        String url = "http://www.szrc.cn/HrMarket/WLZP/ZP/0/%E6%95%B0%E6%8D%AE";

        //依靠NetDiscovery，我们只需要写一个parser类就可以实现基本的爬虫功能了
        Spider.create()
                .name("spider-1")         //名字随便起
                .url(url)
                .parser(new TestParser())  //parser类
                .run();
    }
}
