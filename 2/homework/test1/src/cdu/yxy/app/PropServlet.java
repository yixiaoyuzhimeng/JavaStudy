package cdu.yxy.app;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Properties;

@WebServlet("/prop")
public class PropServlet extends HttpServlet {

    Properties properties=new Properties();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext=config.getServletContext();
        InputStream inputStream=servletContext.getResourceAsStream("WEB-INF/classes/my.properties");
        //路径为属性文件在项目生成目录（out）中的路径
        try {
            properties.load(new InputStreamReader(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取文字
        String result=properties.getProperty("my.name");
        result += properties.getProperty("my.id");
        //准备画布
        int width=200;
        int height=80;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g=image.getGraphics();
        //准备画笔并画在画布上
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
        g.setColor(Color.RED);
        g.drawString(result,0,40);
        //把画布显示在页面上
        ImageIO.write(image,"png",resp.getOutputStream());
    }


}
