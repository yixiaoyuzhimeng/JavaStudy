package dao.impl;

import dao.BaseDao;
import dao.Dao;
import model.Choose;
import model.Course;
import model.Student;
import model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl extends BaseDao implements Dao {
    PreparedStatement preparedStatement = null;
    @Override
    public int insert(Student student) {
        int rows = 0;
        String sql = "insert into student(studentId, studentName, studentPwd, studentSex, studentAge) values (?, ?, ?, ?, ?)";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setString(3, student.getStudentPwd());
            preparedStatement.setString(4, student.getStudentSex());
            preparedStatement.setString(5, student.getStudentAge());
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("学生创建失败" + student);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int insert(Course course) {
        int rows = 0;
        String sql = "insert into course(courseId, courseName, teacherName) values (?, ?, ?)";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, course.getCourseId());
            preparedStatement.setString(2, course.getCourseName());
            preparedStatement.setString(3, course.getTeacherName());
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("数据库出错" + course);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int insert(Choose choose) {
        int rows = 0;
        String sql = "insert into choose(name, studentId) values (?, ?)";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, choose.getName());
            preparedStatement.setInt(2, choose.getStudentId());
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("选课失败");
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows = 0;
        String sql = "delete from course where `name`=?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int deleteCh(int id) {
        int rows = 0;
        String sql = "delete from choose where id=?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public Choose findById(int id) {
        Choose choose = null;
        String sql = "select * from choose where id=?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                choose = new Choose();
                choose.setId(resultSet.getInt("id"));
                choose.setName(resultSet.getInt("name"));
                choose.setStudentId(resultSet.getInt("studentId"));
                choose.setScore(resultSet.getInt("score"));
            }
        } catch (SQLException e) {
            System.out.println("查看失败");
            e.printStackTrace();
        }
        return choose;
    }

    @Override
    public int update(Choose choose) {
        int rows = 0;
        String sql = "update choose set score=? where id=?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, choose.getScore());
            preparedStatement.setInt(2, choose.getId());
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("成绩上传失败");
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public Student findByNameAndPwd(int id, String pwd) {
        Student student = null;
        String sql = "select * from student where studentId=? and studentPwd=?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, pwd);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setStudentId(resultSet.getInt("studentId"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setStudentPwd(resultSet.getString("studentPwd"));
                student.setStudentSex(resultSet.getString("studentSex"));
                student.setStudentAge(resultSet.getString("studentAge"));
            }
        } catch (SQLException e) {
            System.out.println("id=" + id + ", pwd=" + pwd);
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Teacher findNameAndPwd(int id, String pwd) {
        Teacher teacher = null;
        String sql = "select * from teacher where teacherId=? and teacherPwd=?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, pwd);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt("teacherId"));
                teacher.setTeacherName(resultSet.getString("teacherName"));
                teacher.setTeacherPwd(resultSet.getString("teacherPwd"));
                teacher.setTeacherSex(resultSet.getString("teacherSex"));
                teacher.setTeacherAge(resultSet.getString("teacherAge"));
            }
        } catch (SQLException e) {
            System.out.println("");
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public List<Course> findByPage(int start, int num) {
        List<Course> courseList = new ArrayList<Course>();
        String sql = "select * from course order by `name` desc limit ?, ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, num);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setName(resultSet.getInt("name"));
                course.setCourseId(resultSet.getInt("courseId"));
                course.setCourseName(resultSet.getString("courseName"));
                course.setTeacherName(resultSet.getString("teacherName"));
                courseList.add(course);
            }
        }catch (SQLException e){
            System.out.println("失败");
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public List<Choose> findChoose(int studentId) {
        List<Choose> chooseList = new ArrayList<Choose>();
        String sql = "select courseId, courseName, teacherName, score from choose, course where choose.studentId = ? and choose.name=course.name";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Choose choose = new Choose();
                choose.setCourseId(resultSet.getInt("courseId"));
                choose.setCourseName(resultSet.getString("courseName"));
                choose.setTeacherName(resultSet.getString("teacherName"));
                choose.setScore(resultSet.getInt("score"));
                chooseList.add(choose);
            }
        } catch (SQLException e) {
            System.out.println("失败");
            e.printStackTrace();
        }
        return chooseList;
    }

    @Override
    public List<Choose> findPage(int start, int num) {
        List<Choose> chooseList = new ArrayList<Choose>();
        String sql = "select * from choose, student, course where choose.name=course.name and choose.studentId=student.studentId order by `id` desc limit ?, ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, num);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Choose choose = new Choose();
                choose.setId(resultSet.getInt("id"));
                choose.setCourseId(resultSet.getInt("courseId"));
                choose.setCourseName(resultSet.getString("courseName"));
                choose.setTeacherName(resultSet.getString("teacherName"));
                choose.setStudentId(resultSet.getInt("studentId"));
                choose.setStudentName(resultSet.getString("studentName"));
                choose.setScore(resultSet.getInt("score"));
                chooseList.add(choose);
            }
        }catch (SQLException e){
            System.out.println("失败");
            e.printStackTrace();
        }
        return chooseList;
    }

    @Override
    public int getCount(String sql) {
        int count = 0;
        // String sql = "select count(*) from course";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("数据库操作计数失败");
            e.printStackTrace();
        }
        return count;
    }
}
