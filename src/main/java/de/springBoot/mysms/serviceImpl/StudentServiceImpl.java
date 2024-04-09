package de.springBoot.mysms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.springBoot.mysms.dao.StudentRepository;
import de.springBoot.mysms.entity.Student;
import de.springBoot.mysms.exception.ResourceNotFoundException;
import de.springBoot.mysms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student studentSave(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student searchStudentById(Long id) {
		/*
		 * Optional<Student> studentById = studentRepository.findById(id);
		 * 
		 * if(studentById.isPresent()) { return studentById.get(); } else { throw new
		 * ResourceNotFoundException("Student", "Id", id); }
		 */
		
		return studentRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Student", "id", id));
	}

	@Override
	public Student updateStudentById(Student student, Long id) {
		
		Student existingStudent = studentRepository.findById(id).orElseThrow(
				            () -> new ResourceNotFoundException("Student", "Id", id));
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentRepository.save(existingStudent);
		
		return existingStudent;
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Student", "Id", id));
		
		studentRepository.deleteById(id);
	}

}





















