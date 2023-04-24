package util;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/validCode")
public class ValidCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width=50;
        int height=20;
        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics g=bufferedImage.getGraphics();

        //生成验证码
        Random random =new Random();
        String validCode="";
        //验证码一：四位随机数字
//        int code=1000+random.nextInt(9000);
//        validCode=String.valueOf(code);
        //验证码二：四位随机字符
        String codes="abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ0123456789";
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<4;i++){
            stringBuilder.append(codes.charAt(random.nextInt(codes.length())));
        }
         validCode=stringBuilder.toString();
        System.out.println("生成的验证码是："+validCode);

        //保存验证码,在会话范围内保存
        HttpSession session=request.getSession();
        session.setAttribute("validCode",validCode);

        //绘制背景
        g.setColor(new Color(0xffcccccc));
        g.fillRect(0,0,width,height);

        //绘制验证码
        g.setColor(Color.red);
        g.setFont(new Font("黑体",Font.BOLD,18));
        g.drawString(String.valueOf(validCode),4,17);

        //禁止缓存
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","No-cache");
        response.setDateHeader("Expires",0);

        //返回响应
        ImageIO.write(bufferedImage,"png",response.getOutputStream());

    }


}
