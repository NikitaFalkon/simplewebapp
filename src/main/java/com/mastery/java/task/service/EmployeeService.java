package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) { return employeeRepository.findById(id); }

    public Boolean deleteById(Long id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }

        return true;
    }

    public void replace(Long id, Employee employeeRep) {
        employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirst_name(employeeRep.getFirst_name());
                    employee.setLast_name(employeeRep.getLast_name());
                    employee.setDepartament_id(employeeRep.getDepartament_id());
                    employee.setJob_title(employeeRep.getJob_title());
                    employee.setDate_of_birth(employeeRep.getDate_of_birth());
                    employee.setGender(employeeRep.getGender());
                    employeeRepository.save(employee);
                    return null;
                });
    }
}
