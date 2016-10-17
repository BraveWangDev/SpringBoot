package com.example.SpringData.dao;

import com.example.SpringData.domain.Course;
import com.example.SpringData.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Brave on 16/10/12.
 */
public interface CourseRepository extends JpaRepository<Course, Long> {

//    Student findByName(String name);
//
//    Student findByNameAndAge(String name, Integer age);
//
//    @Query("from User u where u.name=:name")
//    Student findUser(@Param("name") String name);

}

