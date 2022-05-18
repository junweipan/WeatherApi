package com.junwei.weatherapis.controller;
import java.util.List;

import com.junwei.weatherapis.model.Student;
import com.junwei.weatherapis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//creating RestController
@RestController
public class StudentController {
    //自动装配 StudentService 类
    @Autowired
    StudentService studentService;
    //创建从数据库检索所有学生详细信息的get映射
    @GetMapping("/student")
    private List<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }
    //创建检索特定学生详细信息的get映射
    @GetMapping("/student/{id}")
    private Student getStudent(@PathVariable("id") int id)
    {
        return studentService.getStudentById(id);
    }
    //创建删除映射，删除特定的学生
    @DeleteMapping("/student/{id}")
    private void deleteStudent(@PathVariable("id") int id)
    {
        studentService.delete(id);
    }
    //创建在数据库中发布学生详细信息的post映射
    @PostMapping("/student")
    private int saveStudent(@RequestBody Student student)
    {
        studentService.saveOrUpdate(student);
        return student.getId();
    }
}
