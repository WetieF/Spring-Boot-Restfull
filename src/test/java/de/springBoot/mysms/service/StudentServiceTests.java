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
        student.setFirstName("Eva");
        student.setLastName("Njango");
        student.setEmail("eva@gxm.de");
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
        Assertions.assertThat(savedStudent.getFirstName()).isEqualTo("Eva");
    }
}
