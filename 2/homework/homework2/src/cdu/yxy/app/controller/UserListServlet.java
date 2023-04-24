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
import java.util.List;
@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        String sPage =req.getParameter("page");
        int page=1;
        if(sPage!=null &&!sPage.equals("")){
            page=Integer.parseInt(sPage);
        }
        int pageSize=2;
        int count =userService.count();
        int pageNum=count%pageSize==0?count/pageSize:count/pageSize+1;//这里不理解 TODO
        List<User> userList =userService.findByPage(page,pageSize);
        req.setAttribute("userList",userList);
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);
        req.setAttribute("pageNum",pageNum);
        req.setAttribute("count",count);
        RequestDispatcher dispatcher=req.getRequestDispatcher("list.do");
        dispatcher.forward(req,resp);
    }
}
