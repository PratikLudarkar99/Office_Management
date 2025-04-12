package com.demo.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    private String joiningDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id", referencedColumnName = "id")
    private Salary salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}