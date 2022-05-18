package com.junwei.weatherapis.service;
import java.util.ArrayList;
import java.util.List;

import com.junwei.weatherapis.model.Student;
import com.junwei.weatherapis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //get all records
    public List<Student> getAllStudent()
    {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }
    //获取特定记录
    public Student getStudentById(int id)
    {
        return studentRepository.findById(id).get();
    }
    public void saveOrUpdate(Student student)
    {
        studentRepository.save(student);
    }
    //删除特定记录
    public void delete(int id)
    {
        studentRepository.deleteById(id);
    }
}
