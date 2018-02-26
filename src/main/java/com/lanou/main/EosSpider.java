package com.lanou.main;

import com.cv4j.netdiscovery.core.Spider;
import com.cv4j.netdiscovery.core.SpiderEngine;
import com.cv4j.netdiscovery.extra.downloader.httpclient.HttpClientDownloader;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class EosSpider {

    public static void main(String[] args) {
        //爬虫容器引擎
        SpiderEngine engine = SpiderEngine.create();

        String eosUrl = "https://bing.ioliu.cn";

        long periodTime1 = 1000 * 5;
        Spider spider1 = Spider.create()
                .name("EOS")
                .repeatRequest(periodTime1, eosUrl)
                .parser(new EosParser())
                .downloader(new HttpClientDownloader())
                .initialDelay(periodTime1);

        engine.addSpider(spider1);

        engine.httpd(8088);     //这一行要注意，通过接口可以获取访问爬虫容器内的状态
        engine.runWithRepeat();

    }
}
