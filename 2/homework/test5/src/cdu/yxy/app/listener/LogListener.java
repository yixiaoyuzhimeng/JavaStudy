package cdu.yxy.app.listener;

import cdu.yxy.app.model.User;
import cdu.yxy.app.util.MyDate;
import com.mysql.cj.Session;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.io.*;

import static jdk.nashorn.internal.objects.NativeMath.log;

@WebListener
public class LogListener implements ServletContextListener, HttpSessionAttributeListener,HttpSessionListener,ServletRequestAttributeListener {
    File logFile;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String logDirPath=sce.getServletContext().getRealPath("log");
        File logDir=new File(logDirPath);
        if(!logDir.exists()){
            System.out.println("日志不存在，新建："+logDir.mkdir());
        }
        if(!logDir.isDirectory()){
            System.out.println("日志目录有误，删除："+logDir.delete());
            System.out.println("日志目录重建："+logDir.mkdir());
        }
        logFile=new File(logDirPath+"/"+ MyDate.today()+".txt");
        try {
            fileWriter=new FileWriter(logFile,true);
            bufferedWriter=new BufferedWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        User user=null;
        if(se.getName().equals("user")){
            user=(User)se.getValue();
        }
        log(user,"登录");
    }
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        User user=(User) se.getSession().getAttribute("user");
        String action =(String) se.getSession().getAttribute("action");
        log(user,action);
    }
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("action","");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        User user=(User) se.getSession().getAttribute("user");
        log(user,"注销");
    }
    private void log(User user,String action){
        if(user==null||action==null){
            return;
        }
        String info="\n";
        if(user.getIsAdmin()){
            info+="管理员";
        }
        info+=user.getName()+"("+user.getId()+")"+action+":"+MyDate.now()+"\n";
        try {
            bufferedWriter.append(info);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
