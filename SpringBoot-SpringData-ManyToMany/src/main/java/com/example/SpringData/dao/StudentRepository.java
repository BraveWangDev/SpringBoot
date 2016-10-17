package com.example.SpringData.dao;

import com.example.SpringData.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Brave on 16/10/12.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

//    Student findByName(String name);
//
//    Student findByNameAndAge(String name, Integer age);
//
//    @Query("from User u where u.name=:name")
//    Student findUser(@Param("name") String name);

}

