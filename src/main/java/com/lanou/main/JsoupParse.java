package com.lanou.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class JsoupParse {

    public static void main(String[] args) throws IOException {


        String url = "https://bing.ioliu.cn";
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                .get();

        Elements pages = document.select(".page").select("span");

        int count = Integer.parseInt(pages.html().substring(pages.html().lastIndexOf("/") + 1).trim());

        System.out.println("总页数：" + count);

        //https://bing.ioliu.cn/?p=2
        for (int i = 1; i < count; i++) {
            String u = url + "?p=" + i;
            jsoup(u);
            System.out.println("第 " + i + " 页完事");
        }

    }

    public static void jsoup(String url) throws IOException {
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                .get();

        Elements mains = document.select(".item");

        Elements downloadA = mains.select("a.ctrl.download");

        for (Element e : downloadA) {

            String imgUrl = e.attr("abs:href");
            System.out.println(imgUrl);

            fileDownload(imgUrl);

        }

    }

    public static void fileDownload(String path) throws IOException {
        String filename = path.substring(path.lastIndexOf("/"), path.lastIndexOf("?"));

        URL url = new URL(path);

        URLConnection connection = url.openConnection();

        InputStream is = connection.getInputStream();

        File file = new File("/Users/lilyxiao/web/temp/picture", filename + ".png");

        OutputStream fos = new FileOutputStream(file);

        byte[] buf = new byte[1024];
        int l = 0;
        while ((l = is.read(buf)) != -1) {
            fos.write(buf, 0, l);
        }

        fos.close();
        is.close();

    }
}
