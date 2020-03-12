package servlet;

import util.DownloadUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 资源下载器
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String file = req.getParameter("filename");
        // 中文解码
        String filename = URLDecoder.decode(file,"UTF-8");
        // 字节加载流，记载文件进内存
            // 文件服务器的路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);

        // 字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        // 设置响应头
        String mimeType = context.getMimeType(filename);
        resp.setHeader("content-type", mimeType);

        // 解决中文文件名的问题
            // 获取user-agent请求头
        // String agent = resp.getHeader("user-agent");
        filename = URLEncoder.encode(filename, "UTF-8");
        // 设置响应头打开方式:content-disposition
        resp.setHeader("content-disposition","attachment;filename="+filename);
        // 将输入流的数据写出到输出流中
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }

        fis.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
