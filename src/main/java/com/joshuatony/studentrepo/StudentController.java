package com.joshuatony.studentrepo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    ///FIND ALL STUDENT
    @GetMapping("")
    List<Student> findAll() {
        return studentService.getAllStudents();
    }

    ///FIND STUDENT BY EMAIL
    @GetMapping("/email")
    Student findByEmail(@RequestBody String email) {

        Optional<Student> student = studentService.getStudentByEmail(email);
        if(student.isEmpty()) {
            throw new StudentNotFoundException();
        }
        return student.get();
    }

    ///POST NEW STUDENT
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Student student) {
        studentService.create(student);
    }


    ///EDIT STUDENT DATA
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Student student, @PathVariable String id) {
        studentService.update(student, id);
    }


    ///DELETE STUDENT DATA
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("")
    void delete(@RequestBody EmailSearch email) {
        Optional<Student> student = studentService.getStudentByEmail(email.getEmail());
        if(student.isEmpty()){
            throw new StudentNotFoundException();
        }
        studentService.delete(student.get());
    }

    // @GetMapping("/{id}")
    // Student findById(@PathVariable Integer id) {
    //     Optional<Student> student = studentRepository.findById(id);
    //     if(student.isEmpty()) {
    //         throw new StudentNotFoundException();
    //     }
    //     return student.get();
    // }
}
