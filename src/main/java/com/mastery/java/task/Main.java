package com.mastery.java.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}


//    IF NOT EXISTS ( SELECT * FROM employees)
//BEGIN
//        INSERT INTO employee (first_name, last_name, departament_id, job_title, gender,  date_of_birth)
//        VALUES ('Pit', 'Mark', 2, 'clicking_on_buttons', 'MALE', 12.05.2000) ;
//        END

//    SELECT COUNT (departament_id) as a FROM employee;
//
//if a = 0 then (INSERT INTO employee (first_name, last_name, departament_id, job_title, gender,  date_of_birth)
//        VALUES ('Pit', 'Mark', 2, 'clicking_on_buttons', 'MALE', '23-05-2015'));