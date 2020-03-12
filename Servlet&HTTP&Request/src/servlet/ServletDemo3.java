package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示Request 获取请求头数据
 */

@WebServlet("/requestDemo3")
public class ServletDemo3 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取请求头数据： User-Agent
        String agent = req.getHeader("user-agent");
        System.out.println("User-Agent:" + agent);

        // 判断浏览器：
        /*if(agent.contains("Chrome")){
            System.out.println("Chrome Browser....");
        }else if(agent.contains("Firefox")){
            System.out.println("Firefox Browser.....");
        }*/

        // 获取请求头数据：referer
        String referer = req.getHeader("referer");
        System.out.println("referer:" + referer);

        // 防盗链
        if(referer != null){
            if(referer.contains("/da")){
                // 正常访问
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("播放电影.....");
            }else{
                // 盗链
                resp.setContentType("text/html; charset=utf-8");
                resp.getWriter().write("看电影，去优酷吧....");
            }
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

    }

}
