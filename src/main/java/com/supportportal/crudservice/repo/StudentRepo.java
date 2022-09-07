package com.supportportal.crudservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supportportal.crudservice.model.Student;



@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
