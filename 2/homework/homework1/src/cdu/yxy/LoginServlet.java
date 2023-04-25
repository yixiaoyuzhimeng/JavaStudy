package cdu.yxy;

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

////        保存或删除cookie（但这里不太合逻辑，因为一般登陆上之后保存更可靠，不然你会保存一个没用的账号密码）
////        判断saveUser==on(checkbox的选项就是on或者null)
        Cookie cUsername=new Cookie("username",username);
        Cookie cPassword=new Cookie("password",password);
        if(saveUser!=null && saveUser.equals("on")){ //saveUser.equals("on")?
//        保存：设置cookie的生存期限为一周
            cUsername.setMaxAge(24*60*60);
            cPassword.setMaxAge(24*60*60);
        }
        else{
//         删除：生存期为0
            cUsername.setMaxAge(0);
            cPassword.setMaxAge(0);
        }
        response.addCookie(cUsername);
        response.addCookie(cPassword);


//        验证验证码
//        取出已保存的验证码
        HttpSession session=request.getSession();
        String validCode= (String) session.getAttribute("validCode");
        System.out.println("输入的验证码：inputCode="+inputCode);
        System.out.println("已保存的验证码：validCode="+validCode);
        if(!validCode.equals(inputCode)){
            response.sendRedirect("loginPage");
            return;
        }

//        验证用户名和密码(因为这里没有数据库连接，就将用户名和密码相同作为验证方式)
        if(username.equals(password)){
//                Session中保存用户名
            session.setAttribute("username",username);
            response.sendRedirect("success");
        }else{
//            sendRedirect是重定向

            response.sendRedirect("loginPage");
        }
    }
}
