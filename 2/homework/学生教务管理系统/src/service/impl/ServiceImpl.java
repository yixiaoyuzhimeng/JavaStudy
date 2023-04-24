package service.impl;

import dao.BaseDao;
import dao.Dao;
import dao.impl.DaoImpl;
import model.Choose;
import model.Course;
import model.Student;
import model.Teacher;
import service.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {
    Dao dao = new DaoImpl();
    @Override
    public boolean add(Course course) {
        return dao.insert(course) == 1 ? true : false;
    }

    @Override
    public boolean add(Student student) {
        return dao.insert(student) == 1 ? true : false;
    }

    @Override
    public boolean add(Choose choose) {
        return dao.insert(choose) == 1 ? true : false;
    }

    @Override
    public boolean mod(Choose choose) {
        return dao.update(choose) == 1 ? true : false;
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id) == 1 ? true : false;
    }

    @Override
    public boolean deleteCh(int id) {
        return dao.deleteCh(id) == 1 ? true : false;
    }

    @Override
    public Choose get(int id) {
        return dao.findById(id);
    }

    @Override
    public Course getCou(int id) {
        return null;
    }

    @Override
    public Student checkLoginStu(Integer studentId, String password) {
        return dao.findByNameAndPwd(studentId, password);
    }

    @Override
    public Teacher checkLoginTea(Integer teacherId, String password) {
        return dao.findNameAndPwd(teacherId, password);
    }

    @Override
    public List<Course> findByPage(int page, int pageSize) {
        if (page > 0) {
            return dao.findByPage((page -1) * pageSize, pageSize);
        } else {
            return dao.findByPage(0, pageSize);
        }
    }

    @Override
    public List<Choose> findChoose(int studentId) {
        return dao.findChoose(studentId);
    }

    @Override
    public List<Choose> findPage(int page, int pageSize) {
        if (page > 0) {
            return dao.findPage((page -1) * pageSize, pageSize);
        } else {
            return dao.findPage(0, pageSize);
        }
    }

    @Override
    public int getCount(String sql) {
        return dao.getCount(sql);
    }
}
