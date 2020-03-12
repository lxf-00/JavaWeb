package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URL;

public class JsoupDemo2 {
    public static void main(String[] args) throws Exception {
        // 通过指定的url获取html xml
        URL url = new URL("https://www.baidu.com");
        Document parse = Jsoup.parse(url, 10000);
        System.out.println(parse);
    }
}
