package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo3 {
    /**
     * Document/Element
     */
    public static void main(String[] args) throws Exception {
        // 获取student.xml 的路径
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        // Document 对象
        Document parse = Jsoup.parse(new File(path), "utf-8");

        // 获取所有student的对象
        Elements students = parse.getElementsByTag("student");
        // System.out.println(students);

        // 获取属性名为id的元素对象们
        Elements ids = parse.getElementsByAttribute("id");
        // System.out.println(ids);

        // 获取 number属性值为heima_0001的元素对象
        Elements stu2 = parse.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(stu2);

    }
}
