package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.StudentRepository;

import java.util.List;
@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    @Autowired public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student create(Student student) {
      return this.studentRepository.save(student);
    }

    @Override
    public Student read(Long s) {
        return  this.studentRepository.findById(s).orElse(null);
    }

    @Override
    public Student update(Student student) {
      return this.studentRepository.save(student);
    }
    @Override
    public Student findByEmail(String email) {
        return this.studentRepository.findByEmail(email);
    }

    @Override
    public List<Student> getAll() {
       return  this.studentRepository.findAll();
    }
}
