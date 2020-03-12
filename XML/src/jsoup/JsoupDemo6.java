package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupDemo6 {
    /**
     * xpath 查询
     */
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        // 获取student.xml 的路径
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        // Document 对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 根据document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);

        // 查询所有student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }

        System.out.println("-------------------------");

        // 查询所有student标签下的name标签
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode);
        }

        System.out.println("-------------------------");

        // 查询student标签下带有id属性的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }



    }
}
