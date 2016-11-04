package com.example.SpringData.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "course")
public class Course implements java.io.Serializable {

    private static final long serialVersionUID = 6398143635533582335L;

    private String pid;
    private String courseName;// 课程名称
    private Set<Student> Student; // 选修课程学生

    public Course() {

    }

    public Course(String pid, String courseName, Set<Student> student) {
        this.pid = pid;
        this.courseName = courseName;
        this.Student = student;
    }

    @Id
    @Column(name = "pid", unique = true, nullable = false, length = 32)
//    @GeneratedValue(generator = "generator")
//    @GenericGenerator(name = "generator", strategy = "uuid")
    public String getPid() {
        return pid;
    }

    @Column(name = "course_name", unique = true, length = 64)
    public String getCourseName() {
        return courseName;
    }

    //mappedBy :
    //          表示当前所在表和 Student 的关系是定义在 Student 里面的 course 这个成员上面的，
    //          他表示此表是一对一关系中的从表，也就是关系是在 Student 表中维护的，
    //          Student 表是关系的维护者，有主导权，它有个外键指向 course (Student 中的 getCourse() )
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "course")
    //NotFound : 意思是找不到引用的外键数据时忽略，NotFound默认是exception
    @NotFound(action = NotFoundAction.IGNORE)
    public Set<Student> getStudent() {
        return Student;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setStudent(Set<Student> student) {
        Student = student;
    }

}
