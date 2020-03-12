package web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 */

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        // 创建对象，验证码图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        // 美化图片
            // 填充背景颜色
        Graphics g = image.getGraphics();   ///画笔对象
        g.setColor(Color.PINK);   // 设置画笔颜色
        g.fillRect(0, 0, width, height);

            // 画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        // 生成随机角标
        Random rm = new Random();
        for(int i = 1; i <= 4; i++){
            int index = rm.nextInt(str.length());
            // 获取字符
            char c = str.charAt(index);
            // 验证码
            g.drawString(c + "", width/5*i, height/2 );
        }

        // 画干扰线
        g.setColor(Color.GREEN);
        // 生成随机坐标
        for(int i = 0; i < 10; i++){
            int x1 = rm.nextInt(width);
            int x2 = rm.nextInt(width);

            int y1 = rm.nextInt(height);
            int y2 = rm.nextInt(height);

            g.drawLine(x1, y1, x2, y2);
        }

        // 将图片输出到页面上
        ImageIO.write(image, "jpg", resp.getOutputStream());

    }
}
