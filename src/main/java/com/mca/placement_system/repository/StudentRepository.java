package com.mca.placement_system.repository;

import com.mca.placement_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findBySkillContainingIgnoreCase(String skill);


}

