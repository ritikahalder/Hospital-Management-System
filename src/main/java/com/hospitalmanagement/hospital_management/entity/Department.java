package com.hospitalmanagement.hospital_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Department {
    @Id
    private Long departmentId;
}
