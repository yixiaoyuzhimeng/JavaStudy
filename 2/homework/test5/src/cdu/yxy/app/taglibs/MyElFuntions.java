package cdu.yxy.app.taglibs;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MyElFuntions {
    public static SimpleDateFormat sdfYMD=new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sdfYMDHMS =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String currency(BigDecimal money){
        return DecimalFormat.getCurrencyInstance(Locale.CHINA).format(money);
    }
    public static String formatDate(long time){
        return sdfYMD.format(time);
    }
    public static String formatDatetime(long time){
        return sdfYMDHMS.format(time);
    }
}
