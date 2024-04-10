package de.springBoot.mysms.service;

import de.springBoot.mysms.dao.StudentRepository;
import de.springBoot.mysms.entity.Student;
import de.springBoot.mysms.serviceImpl.StudentServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    Student student;

    @BeforeEach
    public void setup() {
        student = new Student();
        student.setFirstName("Evariste");
        student.setLastName("Njango");
        student.setEmail("evariste@gxm.de");
    }

    // JUnit test for save student method
    @DisplayName("JUnit test for save student method")
    @Test
    public void givenStudentObject_whenSaveStudent_thenReturnStudentObject() {

        // given -precondition or setup
        BDDMockito.given(studentRepository.save(Mockito.any(Student.class))).willReturn(student);

        // when - action or behaviour that we are going to test
        Student savedStudent = studentService.studentSave(this.student);

        // then - verify the output
        Assertions.assertThat(savedStudent).isNotNull();
        Assertions.assertThat(savedStudent.getFirstName()).isEqualTo("Evariste");
    }

    // JUnit test for find all students method
    @DisplayName("JUnit test for find all students method")
    @Test
    public void givenStudentList_whenFindAll_thenReturnStudentList() {

        // given -precondition or setup
        Student student1 = new Student();
        student1.setFirstName("Francis");
        student1.setLastName("Wetie");
        student1.setEmail("francis@hotmail.de");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);

        BDDMockito.given(studentRepository.findAll()).willReturn(students);

        // when - action or behaviour that we are going to test
        List<Student> savedStudents = studentService.getAllStudents();

        // then - verify the output
        Assertions.assertThat(savedStudents).isNotNull();
        Assertions.assertThat(savedStudents.size()).isEqualTo(2);
    }

    // JUnit test for searchStudentById method
    @DisplayName("JUnit test for searchStudentById method")
    @Test
    public void givenStudentObject_whenFindById_thenReturnStudentObject() {

        // given -precondition or setup
        Long studentId = 1L;
        Student mockStudent = BDDMockito.mock(Student.class);

        BDDMockito.given(studentRepository.findById(studentId)).willReturn(Optional.of(mockStudent));

        // when - action or behaviour that we are going to test
        Student savedStudent = studentService.searchStudentById(studentId);

        // then - verify the output
        Assertions.assertThat(savedStudent).isNotNull();
    }
}
