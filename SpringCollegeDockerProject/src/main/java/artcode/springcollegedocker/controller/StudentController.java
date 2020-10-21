package artcode.springcollegedocker.controller;

import artcode.springcollegedocker.model.Student;
import artcode.springcollegedocker.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id){
        Student student = studentService.getStudent(id);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity(allStudents, HttpStatus.OK);
    }

    @PostMapping("/put")
    public ResponseEntity putStudent(@RequestBody  Student student){
        studentService.putStudent(student);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteStudent(){
        studentService.deleteAllStudents();
        return new ResponseEntity(HttpStatus.OK);
    }

}
