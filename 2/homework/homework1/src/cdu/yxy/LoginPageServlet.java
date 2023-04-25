package cdu.yxy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginPage")
public class LoginPageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         读取cookie
        String username="";
        String password="";
        Cookie[] cookies=req.getCookies();
        System.out.println("cookies="+cookies);
        if(cookies!=null){
            for(Cookie c:cookies){
                if(c.getName().equals("username")){
                    username=c.getValue();
                }
                if(c.getName().equals("password")){
                    password=c.getValue();
                }
                System.out.println("cookies.name="+username);
                System.out.println("cookies.name="+password);
            }
        }


//        响应登陆界面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang='en'>");
        out.println("<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <title>用户登录</title>\n" +
                "</head>");
        out.println("<body>\n" +
                "    <form action='login' method='post'>");
        out.println("用户名：<input type='text' name='username' value='"+username+"'><br/>");
        out.println("密码：<input type='password' name='password' value='"+password+"'><br/>");
        out.println("验证码：<input type='text' name='inputCode'>");
        out.println(" <img src='ValidCode' width='60' height='22'><br/>");
        out.println("<input type='checkbox' name='saveUser'>保护用户名和密码<br/>");
        out.println("<input type='submit' value='登录'>");
        out.println("<button><a value='注册' href='register.html' target='_blank'><br/>注册</button>");
        out.println(" </form>\n" +
                "</body>\n" +
                "</html>");
    }
}
