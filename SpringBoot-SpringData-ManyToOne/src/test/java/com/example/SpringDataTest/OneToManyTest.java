package com.example.SpringDataTest;

import com.example.DemoApplication;
import com.example.SpringData.dao.CompanyRepository;
import com.example.SpringData.dao.EmployeeRepository;
import com.example.SpringData.domain.Company;
import com.example.SpringData.domain.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Created by Brave on 16/10/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class OneToManyTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Before
    public void testData(){
        //添加公司(和员工关系)
        Company company1 = new Company();
        company1.setCompanyId(1);
        company1.setCompanyName("company1");

        Company company2 = new Company();
        company2.setCompanyId(2);
        company2.setCompanyName("company2");
        companyRepository.save(company1);
        companyRepository.save(company2);

        //添加员工
        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employee1.setEmployeeName("employee1");
        employee1.setCompany(company1);

        Employee employee2 = new Employee();
        employee2.setEmployeeId(2);
        employee2.setEmployeeName("employee2");
        employee2.setCompany(company1);

        Employee employee3 = new Employee();
        employee3.setEmployeeId(3);
        employee3.setEmployeeName("employee3");
        employee3.setCompany(company2);

        Employee employee4 = new Employee();
        employee4.setEmployeeId(4);
        employee4.setEmployeeName("employee4");
        employee4.setCompany(company2);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
    }

    @Test
    public void test() throws Exception {

        // 员工映射公司
        Employee employee = employeeRepository.findOne(1);
        Company company_Temp = employee.getCompany();
        Assert.assertEquals("company1", company_Temp.getCompanyName());

        // 公司映射员工
        Company company = companyRepository.findOne(1);
        Set<Employee> employees = company.getEmployees();
        Assert.assertEquals(2, employees.size());

    }

}
