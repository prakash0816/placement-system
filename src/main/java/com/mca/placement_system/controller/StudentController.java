package com.mca.placement_system.controller;

import com.mca.placement_system.model.Student;
import com.mca.placement_system.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // POST - Add student
    @PostMapping
    public Student add(@Valid @RequestBody Student student) {
        return service.addStudent(student);
    }

    // GET - All students
    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    // GET - By ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteStudent(id);
        return "Deleted successfully";
    }

    // PUT - Update
    @PutMapping("/{id}")
    public Student update(@PathVariable Integer id, @Valid @RequestBody Student student) {
        return service.updateStudent(id, student);
    }
    @GetMapping("/search")
    public List<Student> search(@RequestParam String skill) {
        return service.searchBySkill(skill);
    }

}
