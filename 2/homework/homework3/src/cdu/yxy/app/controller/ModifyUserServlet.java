package cdu.yxy.app.controller;

import cdu.yxy.app.service.UserService;
import cdu.yxy.app.service.impl.UserServiceImpl;
import cdu.yxy.app.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/mod")
public class ModifyUserServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取请求参数
        req.setCharacterEncoding("utf-8");
        User user =new User();
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setName(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setSex(req.getParameter("sex"));
        String[] hobby =req.getParameterValues("hobby");
        System.out.println("获取参数：");
        System.out.println(hobby);
        String hobbies1="";
        StringBuilder stringBuilder=new StringBuilder();
        if(hobby!=null){
            for(String s:hobby){
                stringBuilder.append(s+",");
            }
        }
        if(stringBuilder.length()>0){
            hobbies1=stringBuilder.substring(0,stringBuilder.length());
        }
        user.setHobby(hobbies1);
//        修改入数据库
        if(userService.mod(user)) {
            resp.sendRedirect("list");
        }else{
            req.setAttribute("user",user);
            req.getRequestDispatcher("mod.do").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=userService.get(req.getParameter("id"));
        req.setAttribute("user",user);
        RequestDispatcher rd=req.getRequestDispatcher("mod.do");
        rd.forward(req,resp);
    }
}
