package com.mca.placement_system.service;

import com.mca.placement_system.model.Student;
import com.mca.placement_system.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // ADD THIS METHOD (missing in your project)
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student addStudent(Student s) {
        return repo.save(s);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    public List<Student> search(String q) {
        return repo.search(q);
    }
}
