package de.springBoot.mysms.service;

import java.util.List;

import de.springBoot.mysms.entity.Student;

public interface StudentService {

	Student studentSave(Student student);
	List<Student> getAllStudents();
	Student searchStudentById(Long id);
	Student updateStudentById(Student student, Long id);
	void deleteStudent(Long id);
}
