package com.example.SpringData.domain;

import javax.persistence.*;

/**
 * Created by Brave on 16/10/12.
 */
@Entity
@Table(name = "t_employee")
public class Employee {

    private Integer employeeId;
    private String  employeeName;
    private Company company;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * @ManyToOne：多对一
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name = "cid")
    public Company getCompany() {
        return company;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}