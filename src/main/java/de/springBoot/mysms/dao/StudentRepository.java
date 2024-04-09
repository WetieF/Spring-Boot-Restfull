package de.springBoot.mysms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import de.springBoot.mysms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
