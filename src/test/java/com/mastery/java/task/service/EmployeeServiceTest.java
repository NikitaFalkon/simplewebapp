package com.mastery.java.task.service;

import com.mastery.java.task.dao.impl.EmployeeDaoImpl;
import com.mastery.java.task.dto.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeDaoImpl employeeDao;

    public EmployeeServiceTest() {
    }

    @Test
    public void testNewEmployee() {
        Employee employee = new Employee();
        employee.setFirst_name("name");
        boolean created = this.employeeService.create(employee);
        Assert.assertTrue(created);
        Assert.assertNotNull(employee.getFirst_name());
        (Mockito.verify(this.employeeDao, Mockito.times(1))).create(employee.getFirst_name(),
                employee.getLast_name(),
                employee.getDepartament_id(),
                employee.getJob_title(),
                employee.getGender(),
                employee.getDate_of_birth());
    }


    @Test
    public void testFindAll() {
        Employee employee = new Employee();
        employee.setFirst_name("name");
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        (Mockito.doReturn(employees).when(this.employeeDao)).findAll();
        List<Employee> employees1 = this.employeeService.findAll();
        Assert.assertEquals(employees1.get(0).getFirst_name(), "name");
    }

    @Test
    public void testFindById() {
        Employee employee = new Employee();
        employee.setFirst_name("name");
        (Mockito.doReturn(employee).when(this.employeeDao)).getById(1L);
        Employee employee1 = this.employeeService.findById(1L);
        (Mockito.verify(this.employeeDao, Mockito.times(1))).getById(1L);
        Assert.assertEquals(employee1.getFirst_name(), "name");
    }

    @Test
    public void testRedact()  {
        Employee employee = new Employee();
        employee.setFirst_name("name");
        employee.setEmployee_id(1L);
        Employee employee2 = new Employee();
        employee.setFirst_name("notname");
        this.employeeService.replace(employee.getEmployee_id(), employee2);
        Assert.assertEquals(employee.getFirst_name(), "notname");
    }
}
