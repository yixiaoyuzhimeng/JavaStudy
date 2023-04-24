package cdu.yxy.app.controller;

import cdu.yxy.app.model.User;
import cdu.yxy.app.service.UserService;
import cdu.yxy.app.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        获取用户输入的表单数据
        request.setCharacterEncoding("utf-8");
        String username1=request.getParameter("name");
        String password1=request.getParameter("password");
        String sex=request.getParameter("sex");

        User user =new User();
        user.setName(username1);
        user.setPassword(password1);
        user.setSex(sex);

        String[] hobby =request.getParameterValues("hobby");
        String hobbies="";
        StringBuilder stringBuilder=new StringBuilder();
        if(hobby!=null){
            for(String s:hobby){
                stringBuilder.append(s+",");
            }
        }
        if(stringBuilder.length()>0){
            hobbies=stringBuilder.substring(0,stringBuilder.length());
        }
        user.setHobby(hobbies);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        //        连接数据库，保存用户数据
        UserService userService=new UserServiceImpl();
        if(userService.add(user)){
            out.println("<script>alert('注册成功');"+"window.location.href='login.do'</script>");
            out.close();
        }else{
            out.println("<script>alert('注册失败');"+"window.location.href='register.do'</script>");
            out.close();
        }

    }
}
