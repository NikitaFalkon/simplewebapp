package com.mastery.java.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    @JsonProperty("employee_id")
    private Long employee_id;
    @Column(name = "first_name")
    @JsonProperty("first_name")
    private String first_name;
    @Column(name = "last_name")
    @JsonProperty("last_name")
    private String last_name;
    @Column(name = "departament_id")
    @JsonProperty("departament_id")
    private Integer departament_id;
    @Column(name = "job_title")
    @JsonProperty("job_title")
    private String job_title;
    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    @JsonProperty("gender")
    private Gender gender;
    @Column(name="date_of_birth")
    @JsonProperty("date_of_birth")
    private Date date_of_birth;


    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastName) {
        this.last_name = lastName;
    }

    public Integer getDepartament_id() {
        return departament_id;
    }

    public void setDepartament_id(Integer departamentId) {
        this.departament_id = departamentId;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String jobTitle) {
        this.job_title = jobTitle;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
