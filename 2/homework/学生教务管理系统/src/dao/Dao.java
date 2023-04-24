package dao;

import model.Choose;
import model.Course;
import model.Student;
import model.Teacher;

import javax.swing.*;
import java.util.List;

public interface Dao {
    int insert(Student student);
    int insert(Course course);
    int insert(Choose choose);
    int delete(int id);
    int deleteCh(int id);
    Choose findById(int id);
    int update(Choose choose);
    Student findByNameAndPwd(int id, String pwd);
    Teacher findNameAndPwd(int id, String pwd);
    List<Course> findByPage(int start, int num);
    List<Choose> findChoose(int studentId);
    List<Choose> findPage(int start, int num);
    int getCount(String sql);
}
