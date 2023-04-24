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

@WebServlet("/user/add")
public class AddUserServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User user =new User();
        user.setName(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setSex(req.getParameter("sex"));
        String[] hobby =req.getParameterValues("hobby");
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
        if(userService.add(user)){
//            路径问题 list ? user/list  前者
            System.out.println("添加成功");
            resp.sendRedirect("list");
        }else{
            resp.sendRedirect("addUser.do");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("addUser.do");
    }
}
