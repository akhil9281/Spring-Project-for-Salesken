package com.akhil.salesken.repository;

import com.akhil.salesken.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
