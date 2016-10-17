package com.example.SpringDataTest;

import com.example.DemoApplication;
import com.example.SpringData.dao.CourseRepository;
import com.example.SpringData.dao.StudentRepository;
import com.example.SpringData.domain.Course;
import com.example.SpringData.domain.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Brave on 16/10/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class ManyToManyTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void test() throws Exception {

        Student student1 = new Student();
        student1.setStudentName("Student1");

        Course course = new Course();
        course.setCourseName("course1");

        Set<Course> courses = new HashSet<>();
        courses.add(course);
        student1.setCourse(courses);
        studentRepository.save(student1);



    }

}
