package com.learn.Student;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(final StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<StudentModel> getStudent() {
    return studentRepository.findAll();
  }

  public void addStudent(StudentModel student) throws Exception {
    Optional<StudentModel> getbyemail = studentRepository.findStudentByEmail(
      student.getEmail()
    );
    if (getbyemail.isPresent()) {
      throw new Exception("email is token");
    }
    studentRepository.save(student);
  }

  public void deleteStudent(Long studentId) {
    boolean exist = studentRepository.existsById(studentId);
    if (!exist) {
      throw new IllegalStateException("student doesn't exist ");
    }
    studentRepository.deleteById(studentId);
  }

  public void updateStudent(StudentModel student) {
    boolean exist = studentRepository.existsById(student.getId());
    if (!exist) {
      throw new IllegalStateException("student doesn't exist");
    }
    StudentModel newStudent = new StudentModel();
    newStudent.setId(student.getId());
    newStudent.setName(student.getName());
    newStudent.setEmail(student.getEmail());
    newStudent.setAddress(student.getAddress());
    newStudent.setPhone(student.getPhone());
    newStudent.setAge(student.getAge());

    studentRepository.save(newStudent);
  }
}
