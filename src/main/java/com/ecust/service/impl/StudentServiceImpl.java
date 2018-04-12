package com.ecust.service.impl;

import com.ecust.dao.StudentDao;
import com.ecust.pojo.Student;
import com.ecust.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> queryAll() {
        return studentDao.queryStudentsList();
    }
}
