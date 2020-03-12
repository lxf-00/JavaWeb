package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

public class JsoupDemo4 {
    /**
     * Element对象功能
     */
    public static void main(String[] args) throws Exception {
        // 获取student.xml 的路径
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        // Document 对象
        Document parse = Jsoup.parse(new File(path), "utf-8");

        // 通过Document对象获取name标签，获取所有的name标签
        Elements elements_1 = parse.getElementsByTag("name");
        // System.out.println(elements_1);

        // 通过Element对象获取子标签对象
        Element student_1 = parse.getElementsByTag("student").first();
        // System.out.println(student_1);


        //获取student对象的属性值
        String attr = parse.getElementsByTag("student").attr("NUMBER");
        // System.out.println(attr);

        //获取文本内容
        String student = parse.getElementsByTag("student").text();
        System.out.println(student);

    }
}
