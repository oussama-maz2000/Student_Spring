package com.learn.Student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class StudentModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false)
  private String email;

  private String address;

  @Column(name = "phone", nullable = false)
  private String phone;

  private int age;

  public StudentModel(
    String name,
    String email,
    String address,
    String phone,
    int age
  ) {
    this.name = name;
    this.email = email;
    this.address = address;
    this.phone = phone;
    this.age = age;
  }
}
