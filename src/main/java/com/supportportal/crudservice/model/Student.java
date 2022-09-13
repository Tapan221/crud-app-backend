package com.supportportal.crudservice.model;

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

@Table(name = "STUDENT_TB")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	int roll;
	String name;
	String middleName;
	String lastName;
	String fathersName;
	String mothersName;
	String currentClass;
	double fathersContactNo;
	double mothersContactNo;
	char sex;
}
