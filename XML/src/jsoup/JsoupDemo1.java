package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        // 获取student.xml的路径地址
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        // 解析xml文档，加载文档进内存，获取dom数 --Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 获取元素对象Element
        Elements elements = document.getElementsByTag("name");
        String text = elements.text();
        System.out.println(text);
    }
}
