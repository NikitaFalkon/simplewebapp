package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(Employee employee) {
        if(employeeService.create(employee)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/{id}")
    public Employee getOne(@PathVariable("id") Long id) {
        if (employeeService.existById(id)) {
            return employeeService.findById(id);
        }

        return null;

    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!employeeService.existById(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }

        employeeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/redact",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> replace(@PathVariable("id") Long id, Employee employee) {
        if (!employeeService.existById(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }

        employeeService.replace(id, employee);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
