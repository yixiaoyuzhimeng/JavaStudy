package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.*;
import Util.Util;

public class Dao {

    public  int searchPid(String username,String password)
    {
        Connection conn = Util.getConn();
        Statement state = null;
        ResultSet rs = null;
        int pid=0;
        try {
            String sql="select pid from user where username= '"+username+"' and password='"+password+"'";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while(rs.next()){
                pid = rs.getInt("pid");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            Util.close(state, conn);
        }
        return pid;
    }
    public boolean addtea(Teacher teacher)
    {
        Connection conn = Util.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into teacher(tpid,teaname,sex,txueyuan,zhicheng) value(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teacher.getTpid());
            pstmt.setString(2, teacher.getTeaname());
            pstmt.setString(3, teacher.getSex());
            pstmt.setString(4, teacher.getTxueyuan());
            pstmt.setString(5, teacher.getZhicheng());
            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            Util.close(pstmt, conn);
        }
        if(a>0)
            f=true;

        return f;
    }
    public boolean adduser(String tpid,String password,int pid)
    {
        Connection conn = Util.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into user(username,password,pid) value(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tpid);
            pstmt.setString(2, password);
            pstmt.setInt(3, pid);
            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            Util.close(pstmt, conn);
        }
        if(a>0)
            f=true;

        return f;
    }
    public boolean addstu(Stu stu)
    {
        Connection conn = Util.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into stu(spid,stuname,sex,banji,ye) value(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stu.getSpid());
            pstmt.setString(2, stu.getStuname());
            pstmt.setString(3, stu.getSex());
            pstmt.setString(4, stu.getBanji());
            pstmt.setString(5, stu.getYe());
            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            Util.close(pstmt, conn);
        }
        if(a>0)
            f=true;

        return f;
    }

    public  String searchteaname(String tpid)
    {
        Connection conn = Util.getConn();
        Statement state = null;
        ResultSet rs = null;
        String teaname=null;
        try {
            String sql="select teaname from teacher where tpid= '"+tpid+"'";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while(rs.next()){
                teaname = rs.getString("teaname");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            Util.close(state, conn);
        }
        return teaname;
    }
    public boolean addCourse(Course Course)
    {
        String sql_tpid = "SELECT tpid FROM teacher where teaname='"+Course.getJiaoshi()+"' ";
        System.out.println("dao.addcourse sql_tpid:"+sql_tpid);
        Connection conn = Util.getConn();

        Statement state = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        String tpid = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into course(cpid,cname,num,snum,jiaoshi,tpid) value(?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Course.getCpid());
            pstmt.setString(2, Course.getCname());
            pstmt.setInt(3, Course.getNum());
            pstmt.setInt(4, Course.getSnum());
            pstmt.setString(5, Course.getJiaoshi());

            state = conn.createStatement();
            rs = state.executeQuery(sql_tpid);
            while(rs.next()){
                tpid = rs.getString("tpid");
            }
            System.out.println("dao.addcourse tpid:"+tpid);
            pstmt.setString(6, tpid);

            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            Util.close(pstmt, conn);
        }
        if(a>0)
            f=true;

        return f;
    }
    public int updatetea(Teacher teacher, User user) {
        String sqlTeaname = "update teacher set teaname='" + teacher.getTeaname() + "'where tpid='" + teacher.getTpid() + "'";
        String sqlSex = "update teacher set sex='" + teacher.getSex() +"'where tpid='" + teacher.getTpid() + "'";
        String sqlTxueyuan = "update teacher set txueyuan='" +teacher.getTxueyuan() + "' where tpid='" + teacher.getTpid() + "'";
        String sqlZhicheng = "update teacher set zhicheng='" +teacher.getZhicheng() + "'where tpid='" + teacher.getTpid() + "'";

//        String sql = "update teacher set teaname='" + teacher.getTeaname() + "', sex='" + teacher.getSex()
//                + "', txueyuan='" +teacher.getTxueyuan() + "',zhicheng='" +teacher.getZhicheng() + "'where tpid='" + teacher.getTpid() + "'";

        String sql_pwd = "update user set password = '"+user.getPassword()+"'where username = '" + teacher.getTpid() + "' ";

        Connection conn = Util.getConn();
        Statement state = null;
        int res = 0;
        String A = teacher.getTeaname();
        String B =teacher.getTxueyuan();
        String C = user.getPassword();
        try {
            state = conn.createStatement();
            System.out.println("看看dao.updatetea是不是执行了");
            System.out.println("学院不修改："+teacher.getTxueyuan()==null);
            if(!teacher.getTeaname().equals("")){//未输入姓名则不修改
                state.executeUpdate(sqlTeaname);
            }
            if(!teacher.getSex().equals("")){//未输入性别则不修改
                state.executeUpdate(sqlSex);
            }
            if(!teacher.getTxueyuan().equals("")){
                state.executeUpdate(sqlTxueyuan);
            }
            if(!teacher.getZhicheng().equals("")){
                state.executeUpdate(sqlZhicheng);
            }
            if(!user.getPassword().equals("")){//未输入密码则不修改
                state.executeUpdate(sql_pwd);
            }else{
                System.out.println("密码不修改："+user.getPassword()==null);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            res = -1;
        } finally {
            Util.close(state, conn);
        }
        //无数据修改
        if(teacher.getTeaname().equals("") && teacher.getTxueyuan().equals("") && teacher.getZhicheng().equals("") && user.getPassword().equals("")){
            if(teacher.getSex().equals("") && teacher.getZhicheng().equals("")){
                res = 1;
            }
        }

        return res;
    }

    public int updatestu(Stu stu, User user) {
        String sqlStuname = "update stu set stuname = '" + stu.getStuname() + "' where spid='" + stu.getSpid() + "'";
        String sqlSex = "update stu set sex = '" + stu.getSex() +"' where spid='" + stu.getSpid() + "'";
        String sqlBanji = "update stu set banji = '" +stu.getBanji() + "' where spid='" + stu.getSpid() + "'";
        String sqlYe = "update stu set ye = '" +stu.getYe() + "'where spid='" + stu.getSpid() + "'";
//        String sql = "update stu set stuname='" + stu.getStuname() + "', sex='" + stu.getSex()
//                + "', banji='" +stu.getBanji() + "',ye='" +stu.getYe() + "'where spid='" + stu.getSpid() + "'";
        // 修改密码
        String sql_pwd = "update user set password = '"+user.getPassword()+"'where username = '" + stu.getSpid() + "' ";

        Connection conn = Util.getConn();
        Statement state = null;
        int res = 0;

        try {
            state = conn.createStatement();
            System.out.println("看看dao.updatestu是不是执行了");

            if(!stu.getStuname().equals("")){//未输入姓名则不修改
                state.executeUpdate(sqlStuname);
            }
            if(!stu.getSex().equals("")){//未输入性别则不修改
                state.executeUpdate(sqlSex);
            }
            if(!stu.getBanji().equals("")){
                state.executeUpdate(sqlBanji);
            }
            if(!stu.getYe().equals("")){
                state.executeUpdate(sqlYe);
            }
            if(!user.getPassword().equals("")){//未输入密码则不修改
                state.executeUpdate(sql_pwd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            res = -1;
        } finally {
            Util.close(state, conn);
        }

        if(stu.getStuname().equals("") && stu.getBanji().equals("") && stu.getYe().equals("") && user.getPassword().equals("")){
            if(stu.getSex().equals("")){
                res = 1;
            }
        }
        return res;
    }

    public List<Course> liulankecheng() {
        String sql = "select * from Course";
        List<Course> list = new ArrayList<>();
        Connection conn = Util.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Course bean = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String cname = rs.getString("cname");
                int num = rs.getInt("num");
                int snum = rs.getInt("snum");
                String jiaoshi = rs.getString("jiaoshi");
                bean = new Course(id,cpid, cname, num ,snum,jiaoshi);
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs, state, conn);
        }

        return list;
    }

    public Course searchByid(int id) {
        String sql = "select * from Course where id= '"+id+"'";
        Course Course = null;
        Connection conn = Util.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                //int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String cname = rs.getString("cname");
                int num = rs.getInt("num");
                int snum = rs.getInt("snum");
                String jiaoshi = rs.getString("jiaoshi");
                Course = new Course(cpid, cname, num ,snum,jiaoshi);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs, state, conn);
        }

        return Course;
    }
    public boolean updateCourse(int id,int snum) {
        String sql="update Course set snum='" + snum + "'where id='" + id +"'";
        Connection conn = Util.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;
        try {
            state = conn.createStatement();
            System.out.println("看看dao.updateCourse是不是执行了");
            a = state.executeUpdate(sql);
            System.out.println(a);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }

        System.out.println(f);
        return f;

    }

    public String searchtpid(String jiaoshi) {
        String sql = "select tpid from teacher where teaname= '"+jiaoshi+"'";
        Connection conn = Util.getConn();
        Statement state = null;
        ResultSet rs = null;
        String tpid=null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                tpid=rs.getString("tpid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs, state, conn);
        }

        return tpid;
    }

    public Stu searchstu(String spid) {
        System.out.println("Dao里的searchstu里传入的的spid值："+spid);//这里其实是通过学生姓名寻找学生信息的，这里的spid其实是的是stu.getStuname()
        String sql = "select * from stu where stuname= '"+spid+"'";
        Stu stu = null;
        Connection conn = Util.getConn();
        Statement state = null;
        ResultSet rs = null;
        String spid1 = "";
        String stuname = "";
        String sex = "";
        String banji ="";
        String ye ="";
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                //int id = rs.getInt("id");
                spid1 = rs.getString("spid");
                stuname = rs.getString("stuname");
                sex = rs.getString("sex");
                banji = rs.getString("banji");
                ye = rs.getString("ye");
            }

            stu = new Stu(spid1, stuname, sex ,banji,ye);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs, state, conn);
        }
        System.out.println("获取到stu各个值");
        System.out.println(spid1);
        System.out.println(stuname);
        System.out.println(sex);
        System.out.println(banji);
        System.out.println(ye);
        System.out.println(stu);
        return stu;
    }

    public int addSelect(String cpid,String tpid,String spid,Stu stu) {
//这里的spid是学生姓名
        System.out.println("spid:"+spid+"\n学生:"+stu);
        System.out.println("学生姓名:"+stu.getStuname());
        System.out.println("学生性别:"+stu.getSex());
        System.out.println("学生账号spid:"+stu.getSpid());
        String sql_cname = "select * from Course where cpid= '"+cpid+"'";
        Connection conn = Util.getConn();
        ResultSet rs_cname = null;

        String cname = null;
        int num = 0;//规定选课人数
        int snum = 0;//已选课人数

        PreparedStatement pstmt = null;
        boolean f = false;
        int res=0;//方法返回值
        int count = 0;//记录将 插入数据 是否与 已有数据 重复

        //查询表中是否已有重复数据
        String sql_ifexist = "select count(*) from Selectc where cpid = '"+cpid+"' and stuname = '"+stu.getStuname()+"'";

        try {
            Statement sta = conn.createStatement();
            ResultSet rs_count = sta.executeQuery(sql_ifexist);
            //count
            while (rs_count.next()) {
                count = rs_count.getInt(1);//有重复记录count=0,有count=1
            }
            System.out.println("这里！看学生选课是否重复count:"+count);
            rs_cname = sta.executeQuery(sql_cname);
            while (rs_cname.next()){
                cname = rs_cname.getString("cname");
                num = Integer.parseInt(rs_cname.getString("num"));
                snum = Integer.parseInt(rs_cname.getString("snum"));
            }
            System.out.println("这里！看选课人数:"+num+"总人数："+snum);

            //没同样的记录并且人数未满,添加进选课表
            if(count == 0 && snum < num) {
                String sql = "insert into Selectc(cpid,tpid,spid,stuname,sex,banji,ye,cname) values (?,?,?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, cpid);
                pstmt.setString(2, tpid);
                pstmt.setString(3, spid);
                pstmt.setString(4, stu.getStuname());
                pstmt.setString(5, stu.getSex());
                pstmt.setString(6, stu.getBanji());
                pstmt.setString(7, stu.getYe());
                pstmt.setString(8, cname);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Util.close(pstmt, conn);
        }


        if(count!= 0){//数据重复
            res = 1 ;
        }else if(snum >= num){//选课人数满
            res = 2;
        }


        return res;
    }
    public List<Course> liulankecheng1() {
        String sql = "select * from Course";
        List<Course> list = new ArrayList<>();
        Connection conn = Util.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Course bean = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String cname = rs.getString("cname");
                int num = rs.getInt("num");
                int snum = rs.getInt("snum");
                String jiaoshi = rs.getString("jiaoshi");
                if(snum<num) {
                    bean = new Course(id,cpid, cname, num ,snum,jiaoshi);
                    list.add(bean);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs, state, conn);
        }

        return list;
    }


//    public String selectTpid(String teaname){
//        System.out.println("teaname"+teaname);//此处传过来的是老师的姓名，需转化为教师编号
//        String tpid="";
//        String sql= "select tpid from teacher where teaname='"+teaname+"'";
//        Connection conn = Util.getConn();
//        Statement state = null;
//        ResultSet rs = null;
//        try {
//            state = conn.createStatement();
//            rs = state.executeQuery(sql);
//            tpid = rs.getString("tpid");
//        } catch (SQLException e) {
//            System.out.println("selectTpid问题:"+e.getMessage());
//        } finally {
//            Util.close(rs, state, conn);
//            System.out.println("selectTpid结束");
//        }
//        System.out.println("slectTpid tpid"+tpid);
//        return tpid;
//    }


    public List<Select> searchstuinfo(String tpid) {
//        System.out.println("tpid"+tpid);
//        String tpid2=selectTpid(tpid);
//        System.out.println("tpid2"+tpid);

        String tpid2="01";
        String sql = "select * from selectc where tpid= '"+tpid2+"'";
        Connection conn = Util.getConn();
        Statement state = null;
        ResultSet rs = null;
        List<Select> list = new ArrayList<>();
        System.out.println("Dao.serchInfo执行");
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Select Select = null;
            System.out.println("rs:"+rs);
            System.out.println("Dao.serchInfo tyr内部");
//            System.out.println("rs.cpid:"+rs.getString("cpid"));
//            System.out.println("rs.tpid"+ rs.getString("tpid"));
            while (rs.next()) {
                String cpid = rs.getString("cpid");
                String tpid1 = rs.getString("tpid");
                String spid = rs.getString("spid");
                String stuname = rs.getString("stuname");
                String sex = rs.getString("sex");
                String banji = rs.getString("banji");
                String ye = rs.getString("ye");
                String cname = rs.getString("cname");

                System.out.println("Dao.serchInfo cname:"+cname);

                Select = new Select(cpid,tpid1,spid,stuname,sex ,banji,ye,cname);
                list.add(Select);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("问题:"+e.getMessage());
        } finally {
            Util.close(rs, state, conn);
            System.out.println("结束");
        }

        System.out.println("dao.list:"+list);
        return list;
    }

    public int addGrades(Grades Grades, String tpid)
    {
        String sql_ifStuExist = "select count(*) from Selectc where cpid = '"+Grades.getCpid()+"' and stuname = '"+Grades.getStu_name()+"'";//选课表是否由该学生信息
        String sql_tpid = "select * from Selectc where cpid = '"+Grades.getCpid()+"' and stuname = '"+Grades.getStu_name()+"'";//老师是否为该学生对应课程老师
        String sql_spid = "SELECT spid FROM stu where stuname='"+Grades.getStu_name()+"' ";//获取学生学号spid
        System.out.println("dao.addGrades sql_spid:"+sql_spid);

        String s_tpid = null;
        String spid = null;
        int count = 0 ;//选课表是否由该学生信息
        int count2 = 0 ;//成绩表是否已有该学生成绩
        int res = 0;

        Connection conn = Util.getConn();
        PreparedStatement pstmt = null;

        try {
            //从其他表--stu获取spid
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql_spid);
            while(rs.next()){
                spid = rs.getString("spid");
            }
            System.out.println("dao.addcourse spid:"+spid);

            Statement sta = conn.createStatement();
            ResultSet rs_exit = sta.executeQuery(sql_ifStuExist);
            while (rs_exit.next()) {
                count = rs_exit.getInt(1);//有重复记录count=0,有count=1
            }
            System.out.println("dao.addGrades 这里！看老师录入信息是否符合选课表count:"+count);

            //1.选课表有该学生及对应课程
            if (count != 0){

                ResultSet rs_tpid = sta.executeQuery(sql_tpid);
                while (rs_tpid.next()){
                    s_tpid = rs_tpid.getString("tpid");
                }
                System.out.println("//dao.addGrades s_tpid:"+s_tpid+"tpid:"+tpid);
                boolean x = s_tpid.equals(tpid);
                System.out.println("//dao.addGrades s_tpid == tpid:" +x);

                //2.录入成绩老师为该学生对应课程的老师
                if(s_tpid.equals(tpid)){
                    String sql_ifGradeExist = "select count(*) as num from Grades where spid = '"+spid+"' and cpid = '"+Grades.getCpid()+"'";//成绩表是否已有该学生成绩
                    ResultSet rs_grade_exit = sta.executeQuery(sql_ifGradeExist);
                    while (rs_grade_exit.next()) {
                        int i=Integer.valueOf(rs_grade_exit.getString("num"));
                        System.out.println("****i="+i);
                        count2 = rs_grade_exit.getInt(1);//有重复记录count=0,有count=1
                    }
                    System.out.println("dao.addGrades 这里！看是否录入信息count2:"+count2);

                    //3.成绩还未录入
                    if(count2 == 0){
                        String sql = "insert into grades(stu_name,course_name,grades,cpid,spid) value(?,?,?,?,?)";
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, Grades.getStu_name());
                        pstmt.setString(2, Grades.getCourse_name());
                        pstmt.setInt(3, Grades.getGrades());
                        pstmt.setString(4, Grades.getCpid());
                        pstmt.setString(5, spid);

                        pstmt.executeUpdate();
                    }

                }

            }

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            Util.close(pstmt, conn);
        }
        if(count == 0){//选课表没有该学生信息
            res = 1;
        }else if(count2 != 0){//成绩存在
            res = 2;
        }else if(!s_tpid.equals(tpid)){//不是该学生老师
            res = 3;
        }

        return res;
    }

    public List<Grades> checkgrades() {
        String sql = "select * from grades";
        List<Grades> list = new ArrayList<>();
        Connection conn = Util.getConn();
        Statement state = null;
        ResultSet rs = null;
        System.out.println("Dao.checkGrades");

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Grades bean = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String course_name = rs.getString("course_name");
                int grades = rs.getInt("grades");
                String stu_name = rs.getString("stu_name");
                String spid = rs.getString("spid");

                System.out.println("stuServelet.chhekGrades_try:"+stu_name+course_name+grades+cpid);
                bean = new Grades(stu_name, course_name, grades, cpid,spid);
                list.add(bean);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs, state, conn);
        }

        return list;
    }
}