package de.springBoot.mysms.repository;

import de.springBoot.mysms.dao.StudentRepository;
import de.springBoot.mysms.entity.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class StudentRepositoryTests {

    @Autowired
    private StudentRepository studentRepository;

    // JUnit test for save student method
    @DisplayName("JUnit test for save student method")
    @Test
    public void givenStudentObject_whenSaveStudent_thenReturnStudentObject() {

        // given -precondition or setup
        Student student = new Student();
        student.setFirstName("Francis");
        student.setLastName("Wetie");
        student.setEmail("francis@yahoo.fr");

        // when - action or behaviour that we are going to test
        Student savedStudent = studentRepository.save(student);

        // then - verify the output
        Assertions.assertThat(savedStudent).isNotNull();

    }

    // JUnit test for findById student method
    @DisplayName("JUnit test for findById student method")
    @Test
    public void givenEmployeeId_whenFindById_thenReturnStudentObject() {

        // given -precondition or setup
        Long studentId = 1L;
        Student student = new Student();
        student.setFirstName("Francis");
        student.setLastName("Wetie");
        student.setEmail("francis@yahoo.fr");

        studentRepository.save(student);

        // when - action or behaviour that we are going to test
        Student savedStudent = studentRepository.findById(student.getId()).get();

        // then - verify the output
        Assertions.assertThat(savedStudent.getFirstName()).isEqualTo("Francis");

    }

    // JUnit test for find All students method
    @DisplayName("JUnit test for find All students method")
    @Test
    public void givenStudents_whenFindAll_thenReturnListStudent() {

        // given -precondition or setup
        Student student = new Student();
        student.setFirstName("Francis");
        student.setLastName("Wetie");
        student.setEmail("francis@yahoo.fr");

        Student student1 = new Student();
        student.setFirstName("Francis");
        student.setLastName("Wetie");
        student.setEmail("francis@yahoo.fr");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        studentRepository.saveAll(students);


        // when - action or behaviour that we are going to test
        List<Student> studentList = studentRepository.findAll();

        // then - verify the output
        Assertions.assertThat(studentList).isNotNull();
        Assertions.assertThat(studentList.size()).isEqualTo(2);
    }

    // JUnit test for delete student by id
    @DisplayName("JUnit test for delete student by id")
    @Test
    public void givenEmployeeId_whenDelete_thenReturnEmployeeId() {

        // given -precondition or setup
        Student student = new Student();
        student.setFirstName("Francis");
        student.setLastName("Wetie");
        student.setEmail("francis@yahoo.fr");

        studentRepository.save(student);

        // when - action or behaviour that we are going to test
        studentRepository.deleteById(student.getId());

        Optional<Student> savedStudent = studentRepository.findById(student.getId());

        // then - verify the output
        Assertions.assertThat(savedStudent).isEmpty();
    }
}
