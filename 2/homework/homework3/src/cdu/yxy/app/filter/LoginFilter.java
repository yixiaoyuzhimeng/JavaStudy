//package cdu.yxy.app.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//@WebFilter(filterName = "loginFilter",urlPatterns = {"/*"},
//            initParams = {@WebInitParam(name="permitUrls",value="/login.jsp,/login.do,/ValidCode")})
//public class LoginFilter  implements Filter {
//    String[] permitUrls=null;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        permitUrls=filterConfig.getInitParameter("permitUrl").split(",");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req=(HttpServletRequest) servletRequest;
//        System.out.println("LoginFilter:requestURI="+req.getRequestURI());
//
//        boolean flag=false;
//        for(String url:permitUrls){
//            if(req.getRequestURI().endsWith(url)){
//                flag=true;
//            }
//        }
//        if(flag||req.getSession().getAttribute("user")!=null){
//            System.out.println("-----允许登录");
//            filterChain.doFilter(servletRequest,servletResponse);
//        }else{
//            System.out.println("-----不允许登录");
//            req.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
//        }
//
//    }
//}
