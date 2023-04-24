package service;

import model.Choose;
import model.Course;
import model.Student;
import model.Teacher;

import java.util.List;

public interface Service {
    boolean add(Course course);
    boolean add(Student student);
    boolean add(Choose choose);
    boolean mod(Choose choose);
    boolean delete(int id);
    boolean deleteCh(int id);
    Choose get(int id);
    Course getCou(int id);
    Student checkLoginStu(Integer studentId, String password);
    Teacher checkLoginTea(Integer teacherId, String password);
    List<Course> findByPage(int page, int pageSize);
    List<Choose> findChoose(int studentId);
    List<Choose> findPage(int page, int pageSize);
    int getCount(String sql);
}
