package cdu.yxy.app.controller;

import cdu.yxy.app.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet( "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        解析请求参数
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String inputCode=request.getParameter("inputCode");
        String saveUser=request.getParameter("saveUser");



//        验证验证码
//        取出已保存的验证码
        HttpSession session=request.getSession();
        String validCode= (String) session.getAttribute("validCode");
        System.out.println("输入的验证码：inputCode="+inputCode);
        System.out.println("已保存的验证码：validCode="+validCode);
        if(!validCode.equals(inputCode)){
            response.sendRedirect("login.do");
            return;
        }

//如何通过数据库获得用户名和密码并进行验证呢？可是用户名不唯一，可能重名…
//        User user =new User();
//        user.setName(username);



//        验证用户名和密码
        if(username.equals(password)){
//                保存用户名
            session.setAttribute("username",username);
            response.sendRedirect("success.do");
        }else{
            response.sendRedirect("login.do");
        }
    }
}
