package com.mastery.java.task.service;

import com.mastery.java.task.dao.impl.EmployeeDaoImpl;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDaoImpl employeeDao;

    public Boolean create(Employee employee) {
        return employeeDao.create(employee.getFirst_name(),
                employee.getLast_name(),
                employee.getDepartament_id(),
                employee.getJob_title(),
                employee.getGender(),
                employee.getDate_of_birth());
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public Employee findById(Long id) {
        return employeeDao.getById(id);
    }

    public Boolean deleteById(Long id) {
        Employee employee = findById(id);

        if(employee != null) {
            employeeDao.deleteById(id);
            return true;
        }

        return false;
    }

    public Boolean replace(Long id, Employee employeeRep) {
        if(findById(id) != null) {
            return employeeDao.replace(id,
                    employeeRep.getFirst_name(),
                    employeeRep.getLast_name(),
                    employeeRep.getDepartament_id(),
                    employeeRep.getJob_title(),
                    employeeRep.getGender(),
                    employeeRep.getDate_of_birth());
        }

        return false;
    }
}
