package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee>  {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployee_id(rs.getLong("employee_id"));
        employee.setFirst_name(rs.getString("first_name"));
        employee.setLast_name(rs.getString("last_name"));
        employee.setJob_title(rs.getString("job_title"));
        employee.setDepartament_id(rs.getInt("departament_id"));
        employee.setDate_of_birth(rs.getDate("date_of_birth"));
        employee.setGender(rs.getString("gender"));
        return employee;
    }
}
