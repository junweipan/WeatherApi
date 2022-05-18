package com.junwei.weatherapis.repository;
import com.junwei.weatherapis.model.Student;
import org.springframework.data.repository.CrudRepository;
public interface StudentRepository extends CrudRepository<Student, Integer>
{
}
