package za.ac.cput.service;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Student;

import java.util.List;

public interface IStudentService extends IService<Student, Long> {
    Student findByEmail(String email);
    List<Student> getAll();

}

