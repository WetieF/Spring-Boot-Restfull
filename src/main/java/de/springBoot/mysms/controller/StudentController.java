package de.springBoot.mysms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.springBoot.mysms.entity.Student;
import de.springBoot.mysms.service.StudentService;

@RestController     //@Controller und @ResponseBody.Types
@RequestMapping(path = "/api/students1")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// build create Student REST API
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.studentSave(student), HttpStatus.CREATED);
	}
	
	// build Search All Students REST API
	@GetMapping
	public List<Student> listingAllStudent() {
		return studentService.getAllStudents();
	}
	
	// build find Student by Id REST API
	@GetMapping("{id}")
	public ResponseEntity<Student> lookStudentById(@PathVariable("id") Long id) {
		return new ResponseEntity<Student>(studentService.searchStudentById(id), HttpStatus.OK);
	}
	
	// build update Student by Object und Id REST API
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") Long id) {
		return new ResponseEntity<Student>(studentService.updateStudentById(student, id), HttpStatus.OK);
	}
	
	// build delete Student REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> studentDelete(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student successfully deleted from DB!.", HttpStatus.OK);
	}
}
























