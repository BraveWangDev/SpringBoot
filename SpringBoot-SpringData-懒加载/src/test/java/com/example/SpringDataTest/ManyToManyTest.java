package com.example.SpringDataTest;

import com.example.DemoApplication;
import com.example.SpringData.dao.CourseRepository;
import com.example.SpringData.dao.StudentRepository;
import com.example.SpringData.domain.Course;
import com.example.SpringData.domain.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Brave on 16/10/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class ManyToManyTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Before
    public void testData(){

    }

    @Test
    @Transactional
    public void test() throws Exception {

        //取学生-包含课程对象集
        Student student1 = studentRepository.findByStudentName("Student1");

        //验证懒加载
        Set<Course> course = student1.getCourse();
        System.out.print("course.size()" + course.iterator().next());

    }

}
