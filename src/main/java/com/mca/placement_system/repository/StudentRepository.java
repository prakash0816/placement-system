package com.mca.placement_system.repository;

import com.mca.placement_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;   // 👈 THIS WAS MISSING

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("""
        SELECT s FROM Student s
        WHERE lower(s.rollNumber) LIKE lower(concat('%', :q, '%'))
           OR lower(s.department) LIKE lower(concat('%', :q, '%'))
           OR cast(s.year as string) LIKE concat('%', :q, '%')
    """)
    List<Student> search(@Param("q") String q);
}
