package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo5 {
    /**
     * 选择器查询
     */
    public static void main(String[] args) throws IOException {
        // 获取student.xml 的路径
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        // Document 对象
        Document parse = Jsoup.parse(new File(path), "utf-8");

        Element element_1 = parse.select("name").last();
        // System.out.println(element_1);

        // 查询id值为itcast的元素
        Elements element_2 = parse.select("#itcast");
        // System.out.println(element_2);

        // 获取student标签并且number属性值为heima_0001的age子标签
        Elements element_3 = parse.select("student[number='heima_0001'] > age");
        System.out.println(element_3);
    }
}
