package com.learn.Student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(final StudentService studentService) {
    this.studentService = studentService;
  }

  @RequestMapping("/getStudent")
  @GetMapping
  public List<StudentModel> getStudent() {
    return studentService.getStudent();
  }

  @RequestMapping("/saveStudent")
  @PostMapping
  public void addStudent(@RequestBody final StudentModel newStudent)
    throws Exception {
    studentService.addStudent(newStudent);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long studentId) {
    studentService.deleteStudent(studentId);
  }

  @RequestMapping("/update")
  @PutMapping
  public void putStudent(@RequestBody final StudentModel student) {
    studentService.updateStudent(student);
  }
}
