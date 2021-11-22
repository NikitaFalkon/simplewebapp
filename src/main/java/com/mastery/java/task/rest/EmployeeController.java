package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAll() throws IOException {
        return employeeService.findAll();
    }

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(Employee employee) {
        employeeService.create(employee);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public Optional<Employee> getOne(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        if (!employeeService.findById(id).isPresent()) {
            return "There's no such an employee";
        }

        employeeService.deleteById(id);

        return "Done!";
    }

    @PostMapping(value = "/{id}/redact",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String replace(@PathVariable("id") Long id, Employee employee) {
        if (!employeeService.findById(id).isPresent()) {
            return "There's no such an employee";
        }

        employeeService.replace(id, employee);

        return "Done!";
    }
}
