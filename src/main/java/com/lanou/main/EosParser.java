package com.lanou.main;

import com.cv4j.netdiscovery.core.domain.Page;
import com.cv4j.netdiscovery.core.parser.Parser;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class EosParser implements Parser {
    @Override
    public void process(Page page) {
        String xpathStr = "/html/body/div[3]/div[2]/div/div[1]/h3/html()";
        String marketPrice = page.getHtml().xpath(xpathStr).get();
        System.out.println("marketPrice=" + marketPrice);
    }
}
