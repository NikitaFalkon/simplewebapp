package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;

import java.sql.Date;
import java.util.List;

public interface EmployeeDao {
    Boolean create(String first_name, String last_name, Integer departament_id, String job_title, String gender, Date date_of_birth);
    List<Employee> findAll();
    void deleteById(Long id);
    Boolean replace(Long id, String first_name, String last_name, Integer departament_id, String job_title, String gender, Date date_of_birth);
    Employee getById(Long id);
}
