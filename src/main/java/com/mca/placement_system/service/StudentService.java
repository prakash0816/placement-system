
package com.mca.placement_system.service;
import com.mca.placement_system.exception.StudentNotFoundException;
import com.mca.placement_system.model.Student;
import com.mca.placement_system.repository.StudentRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }


    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    public Student updateStudent(Integer id, Student newData) {
        Student existing = getById(id);

        existing.setName(newData.getName());
        existing.setEmail(newData.getEmail());
        existing.setCgpa(newData.getCgpa());
        existing.setSkill(newData.getSkill());

        return repository.save(existing);
    }
    public List<Student> searchBySkill(String skill) {
        return repository.findBySkillContainingIgnoreCase(skill);
    }

}
