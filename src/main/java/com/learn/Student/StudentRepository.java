package com.learn.Student;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
  @Query("SELECT c FROM StudentModel c WHERE c.email = ?1 ")
  Optional<StudentModel> findStudentByEmail(String email);
}
