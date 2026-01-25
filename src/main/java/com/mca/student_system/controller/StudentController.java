package com.mca.student_system.controller;

import com.mca.student_system.model.Student;
import com.mca.student_system.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // GET ALL students
    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    // ADD student
    @PostMapping
    public Student add(@RequestBody Student s) {
        return service.addStudent(s);
    }

    // DELETE student
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    // SEARCH students
    @GetMapping("/search")
    public List<Student> search(@RequestParam String q) {
        return service.search(q);
    }

    // STUDENT PROFILE (temporary)
    @GetMapping("/me")
    public Student myProfile() {
        return service.getAllStudents().get(0);
    }
}
