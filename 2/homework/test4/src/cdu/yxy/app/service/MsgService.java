package cdu.yxy.app.service;
import cdu.yxy.app.model.Msg;
import java.util.List;
public interface MsgService {
    List<Msg> findByPage(int page,int pageSize,int reStatus);
    List<Msg> findByPage(String sPage,String sPageSize,int reStatus);
    List<Msg> findByPage(String sPage,int reStatus);

    Msg get(String sid);
    Msg get(int id);

    int count(int reStatus);

    boolean add(Msg msg);
    boolean reply(Msg msg);
    boolean del(String sid);
}
