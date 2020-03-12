package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 判断是否第一次访问,
 * 不是，记住上一次访问时间
 * 是，设置lastTime = 当前时间 cookie
 */

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // 设置响应数据和编码方式
            resp.setContentType("text/html;charset=utf-8");
            // 获取cookies
            Cookie[] cookies = req.getCookies();

            // 判断cookies是否空，null
            if(cookies != null && cookies.length > 0){
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    if("lastTime".equals(name)){
                        String value = cookie.getValue();
                        // 设置新的值
                        Date date = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:SS");
                        String str_date = sdf.format(date);

                        cookie.setValue(URLEncoder.encode(str_date, "utf-8"));
                        cookie.setMaxAge(60 * 60 * 24 * 30);
                        resp.addCookie(cookie);

                        // 返回给页面数据
                        value = URLDecoder.decode(value, "utf-8");
                        resp.getWriter().write("<h1>欢迎在此访问， 上次访问时间："+ value+ "</h1>");
                    }
                }
            }else{
                // 首次访问
                // 设置cookie
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:SS");
                String str_date = sdf.format(date);

                Cookie c = new Cookie("lastTime", URLEncoder.encode(str_date, "utf-8"));
                c.setMaxAge(60 * 60 * 24 * 30);
                resp.addCookie(c);
                resp.getWriter().write("<h1>欢迎您， 首次访问...</h1>");

            }
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req, resp);
        }
    }

