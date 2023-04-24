package cdu.yxy.app.filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.List;
public class MyMsgReqWrapper extends HttpServletRequestWrapper {
    List<String> stopwords=null;
    public MyMsgReqWrapper(HttpServletRequest request,List<String> stopwords) {
        super(request);
        this.stopwords=stopwords;
    }
    @Override
    public String getParameter(String name) {
        String text=getRequest().getParameter(name);
        if(name.equals("content")||name.equals("reply")){
            if(text!=null){
                System.out.println("修改前text:"+text);
                text=text.replaceAll(" ","&nbsp;");
                text=text.replaceAll("\r\n","<br>");
                for(String s:stopwords){
                    text=text.replaceAll(s,"*");
                }
                System.out.println("修改后text:"+text);
            }
        }
//        问题1:编码问题（stopWords.txt 网站显示 IDEA编辑器使用的 ）分别的不同
//        问题2：修改前和修改后在控制台里显示的时差不符合逻辑：原因：MyElFunctions里面HH：mm:ss 你的格式化日期时间时的格式设置是12小时制，hh:mm:ss中小写h是12小时，改成HH:mm:ss即成24小时制。其实时间是对的，只是显示时格式设置问题罢了。

        return text;
    }
}
