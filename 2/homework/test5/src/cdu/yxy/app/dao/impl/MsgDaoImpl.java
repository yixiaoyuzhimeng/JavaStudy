package cdu.yxy.app.dao.impl;
import cdu.yxy.app.dao.MsgDao;
import cdu.yxy.app.dao.UserDao;
import cdu.yxy.app.model.Msg;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgDaoImpl extends BaseDao implements MsgDao {
    UserDao userDao=new UserDaoImpl();
    @Override
    public Msg get(int id) {
        Msg msg=null;
        String sql="SELECT * FROM guestbook_table WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while(rs.next()){
                msg=new Msg();
                msg.setId(rs.getInt("id"));
                msg.setUser(userDao.get(rs.getInt("userId")));
                msg.setSubject(rs.getString("subject"));
                msg.setContent(rs.getString("content"));
                msg.setAddMsgTime(rs.getInt("isReplied"));
                msg.setIsReplied(rs.getInt("isReplied"));
                msg.setReUser(userDao.get(rs.getInt("isReplied")));
                msg.setReply(rs.getString("reply"));
                msg.setReTime(rs.getLong("reTime"));
            }
        } catch (SQLException e) {
               System.out.println("Dao获取失败:id="+id);
               e.printStackTrace();
        }
        return msg;
    }

    @Override
    public List<Msg> findAll() {
        List<Msg> msgList=new ArrayList<Msg>();
        String sql="SELECT * FROM guestbook_table ORDER BY addMsgTime DESC";
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Msg msg=new Msg();
                msg.setId(rs.getInt("id"));
                msg.setUser(userDao.get(rs.getInt("userId")));
                msg.setSubject(rs.getString(rs.getInt("subject")));
                msg.setContent(rs.getString("content"));
                msg.setAddMsgTime(rs.getLong("addMsgTime"));
                msg.setIsReplied(rs.getInt("isReplied"));
                msg.setReUser(userDao.get(rs.getInt("reUserId")));
                msg.setReply(rs.getString("reply"));
                msg.setReTime(rs.getLong("reTime"));
                msgList.add(msg);
            }
        } catch (SQLException throwables) {
            System.out.println("Dao获取Msg失败");
            throwables.printStackTrace();
        }
        return msgList;
    }

    @Override
    public List<Msg> findByPage(int start, int num, int reStatus) {
        List<Msg> msgList=new ArrayList<Msg>();
        String sql="SELECT * FROM guestbook_table ORDER BY addMsgTime DESC LIMIT ?,?";
        if(reStatus>0){
            sql+="WHERE isRplied=?";
        }
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,num);
            if(reStatus>0){
                pstmt.setInt(3,reStatus);
            }
            rs=pstmt.executeQuery();
            while(rs.next()){
                Msg msg=new Msg();
                msg.setId(rs.getInt("id"));
                msg.setUser(userDao.get(rs.getInt("userId")));
                msg.setSubject(rs.getString("subject"));
                msg.setContent(rs.getString("content"));
                msg.setAddMsgTime(rs.getLong("addMsgTime"));
                msg.setIsReplied(rs.getInt("isReplied"));
                msg.setReUser(userDao.get(rs.getInt("reUserId")));
                msg.setReply(rs.getString("reply"));
                msg.setReTime(rs.getLong("reTime"));
                msgList.add(msg);
            }
        } catch (SQLException throwables) {
            System.out.println("Dao获取Msg失败");
            throwables.printStackTrace();
        }
        return msgList;
    }

    @Override
    public int count(int reStatus) {
        int count=0;
        String sql="SELECT count(*) FROM guestbook_table";
        if(reStatus>0){
            sql+="WHERE isReplied="+reStatus;
        }
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            System.out.println("Dao获取Msg数量失败");
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public int insert(Msg msg) {
        int rows=0;
        String sql="INSERT INTO guestbook_table(userId,subject,content,addMsgTime)Values(?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,msg.getUser().getId());
            pstmt.setString(2,msg.getSubject());
            pstmt.setString(3,msg.getContent());
            pstmt.setLong(4,new Date().getTime());
            rows=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("Dao插入Msg失败"+sql+","+msg);
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(Msg msg) {
        int rows=0;
        String sql="UPDATE guestbook_table SET userId=?,subject=?,content=?,addMsgTime=?,IsReplied=?,reUserId=?,reply=?,reTime=? WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,msg.getUser().getId());
            pstmt.setString(2,msg.getSubject());
            pstmt.setString(3,msg.getContent());
            pstmt.setLong(4,msg.getAddMsgTime());
            pstmt.setInt(5,msg.getIsReplied());
            pstmt.setInt(6,msg.getReUser().getId());
            pstmt.setString(7,msg.getReply());
            pstmt.setLong(8,msg.getReTime());
            pstmt.setInt(8,msg.getIsReplied());
            rows=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("Dao修改Msg失败"+sql+","+msg);
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int updateReply(Msg msg) {
        int rows=0;
        String sql="UPDATE guestbook_table SET isReplied=?,reUserId=?,reply=?,reTime=? WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,msg.getIsReplied());
            pstmt.setInt(2,msg.getReUser().getId());
            pstmt.setString(3,msg.getReply());
            pstmt.setLong(4,msg.getReTime());
            pstmt.setInt(5,msg.getId());
            rows=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("Dao修改Msg的reply 回复失败"+sql+","+msg);
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows=0;
        String sql="DELETE FROM guestbook_table WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rows=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("Dao删除Msg失败"+sql+",id="+id);
            throwables.printStackTrace();
        }
        return rows;
    }
}
