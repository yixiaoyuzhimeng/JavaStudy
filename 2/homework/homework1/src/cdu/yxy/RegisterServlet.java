package cdu.yxy;

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
        String username1=request.getParameter("username1");
        String password1=request.getParameter("password1");
        String sex=request.getParameter("sex");
        String[]  hobbies=request.getParameterValues("hobby");
        StringBuilder hobby=new StringBuilder();
//        将获取的字符串数组化为一个字符串
        if(hobbies!=null&&hobbies.length>0){
            for(String h:hobbies){
                hobby.append(h+",");
            }
        }
//        连接数据库，保存用户数据
//        TODO
//        暂时使用控制台输出数据来替代数据库操作
        System.out.println("用户名是;"+username1);
        System.out.println("密码是;"+password1);
        System.out.println("性别是;"+sex);
        System.out.println("爱好是;"+hobby);
//        注册结束
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
//        成功：跳转至登录界面（这里没有数据库验证是否重复，一律认为只要不为空就注册成功）
//        失败：跳转回注册界面
        if(username1 != null && username1 != ""  && password1!=null && password1 != "" ){
//            out.println("<script>alert('注册成功');</script>");
//            response.sendRedirect("login");
            out.println("<script>alert('注册成功');"+"window.location.href='loginPage'</script>");
            out.close();
        }else{
            out.println("<script>alert('注册失败');"+"window.location.href='register.html'</script>");
            out.close();
        }
    }
}
