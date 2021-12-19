package com.unc.student.course.registraion.repository;

import com.unc.student.course.registraion.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
