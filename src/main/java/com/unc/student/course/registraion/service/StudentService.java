package com.unc.student.course.registraion.service;


import com.unc.student.course.registraion.model.Student;

import java.util.List;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
