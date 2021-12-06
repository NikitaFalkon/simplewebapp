package com.mastery.java.task.dao.impl;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dao.EmployeeMapper;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class EmployeeDaoImpl implements EmployeeDao {
    Gender[] genders = Gender.values();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Boolean create(String first_name, String last_name, Integer departament_id, String job_title, String gender, Date date_of_birth) {
        for(Gender gender1 : genders) {
            if(gender1.equalsName(gender)) {
                String SQL = "INSERT INTO EMPLOYEE (first_name, last_name, departament_id, job_title, gender, date_of_birth) VALUES (?,?,?,?,?,?)";

                jdbcTemplate.update(SQL, first_name, last_name, departament_id, job_title, gender, date_of_birth);

                return true;
            }
        }


        return false;

    }

    @Override
    public List<Employee> findAll() {
        String SQL = "SELECT * FROM employee";
        return jdbcTemplate.query(SQL, new EmployeeMapper());
    }

    @Override
    public void deleteById(Long id) {
        String SQL = "DELETE FROM employee WHERE employee_id = ?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public Boolean replace(Long id, String first_name, String last_name, Integer departament_id, String job_title, String gender, Date date_of_birth) {
        for(Gender gender1 : genders) {
            if(gender1.equalsName(gender)) {
                String SQL = "UPDATE employee SET first_name = ?, last_name = ?, departament_id = ?, job_title = ?, gender = ?, date_of_birth = ?  WHERE employee_id = ?";
                jdbcTemplate.update(SQL, first_name, last_name, departament_id, job_title, gender, date_of_birth, id);

                return true;
                }
            }

        return false;
        }



    @Override
    public Employee getById(Long id) {
        try{
            String SQL = "SELECT * FROM employee WHERE employee_id = ?";
            Employee employee = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new EmployeeMapper());

            return employee;
        } catch (Exception e) {
            return null;
        }
    }

}
