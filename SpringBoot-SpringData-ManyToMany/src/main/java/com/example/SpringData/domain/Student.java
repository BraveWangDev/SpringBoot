package com.example.SpringData.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
public class Student {

    private String pid;
    private String studentName;
    private Set<Course> course;    //选修课程

    public Student() {

    }

    public Student(String pid, String studentName, Set<Course> course) {
        this.pid = pid;
        this.studentName = studentName;
        this.course = course;
    }

    @Id
    @Column(name = "pid", unique = true, nullable = false, length = 32)
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "uuid")
    public String getPid() {
        return pid;
    }

    @Column(name = "student_name", unique = true, length = 64)
    public String getStudentName() {
        return studentName;
    }

    /**
     * Hibernate 会自动创建一张关系表stu_cou， 里边有俩字段stu_id和cou_id分别为两表主键
     *
     * @return
     */
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "stu_cou", joinColumns = {@JoinColumn(name = "stu_id")}, inverseJoinColumns = {@JoinColumn(name = "cou_id")})
    public Set<Course> getCourse() {
        return course;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

}