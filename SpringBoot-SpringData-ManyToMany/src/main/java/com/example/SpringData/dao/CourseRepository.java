package com.example.SpringData.dao;

import com.example.SpringData.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Brave on 16/10/12.
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseName(String name);
}

