package artcode.springcollegedocker.service;

import artcode.springcollegedocker.model.Student;
import artcode.springcollegedocker.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl{

    private StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    public Student getStudent(Integer id){
        return repository.getOne(id);
    }

    public void putStudent(Student student){
        repository.save(student);
    }

    public void deleteStudent(Integer id){
        repository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public void deleteAllStudents() {
        repository.deleteAll();
    }
}
