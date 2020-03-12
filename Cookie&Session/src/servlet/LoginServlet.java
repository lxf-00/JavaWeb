package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置request编码格式
        req.setCharacterEncoding("utf-8");
        // 获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        // 先获取生成的验证码
        HttpSession session = req.getSession();
        String checkCode_seesion = (String) session.getAttribute("checkCode_session");
        // 删除session中存储的验证码
        session.removeAttribute(checkCode_seesion);
        // 判断验证码是否正确
        if(checkCode_seesion != null && checkCode_seesion.equalsIgnoreCase(checkCode)){
            // 数据库查询，简化
            if("zhangsan".equals(username) && "123".equals(password)){
                // 登录成功
                // 存储用户信息
                session.setAttribute("user", username);
                // 重定向到success.jsp
                resp.sendRedirect(req.getContextPath() + "/success.jsp");
            }else{
                // 登录失败
                // 存储提示信息到session中
                req.setAttribute("login_error", "用户名或密码错误！");
                // 转发到登录页面
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        }else{
            //验证码不一致
            //存储提示信息到request
            req.setAttribute("cc_error","验证码错误");
            //转发到登录页面
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
