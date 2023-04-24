package cdu.yxy;

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
import static java.awt.Font.BOLD;

@WebServlet("/ValidCode")
public class ValidCodeServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//准备画布和画笔
        int width=50;
        int height=22;
        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics g=bufferedImage.getGraphics();

//        生成验证码
        Random random=new Random();
        String validCode="";
//        方式一：四位随机数字
//        int code=1000+random.nextInt(9000);
//        validCode=String.valueOf(code);
//       方式二： 四位随机字符
//        String[] code=new String[]{"abcdefghijklmnABCDEFGHIJKLMN"}
        String codes="abcdefghijkmnABCDEFGHJKLMN";
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<4;i++){
            stringBuilder.append(codes.charAt(random.nextInt(codes.length())));
        }
        validCode=stringBuilder.toString();
        System.out.println("生成的验证码是;"+validCode);

//        保存验证码,在会话范围内保存
        HttpSession session=req.getSession();
        session.setAttribute("validCode",validCode);

//        绘制背景
        g.setColor(new Color(0xffcccccc));
        g.fillRect(0,0,width,height);

//        绘制验证码
        g.setColor(Color.red);
        g.setFont(new Font("黑体",BOLD,18));
        g.drawString(validCode,4,17);


//        禁止缓存
        resp.setHeader("Pragma","No-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires",0);

//          返回响应
        ImageIO.write(bufferedImage,"png",resp.getOutputStream());
    }
}
