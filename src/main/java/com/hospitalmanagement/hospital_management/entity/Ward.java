package com.hospitalmanagement.hospital_management.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity

    public class Ward {
        @Id
        @Column(length = 36)
        private String wardId;

        @Column(length = 50, nullable = false)
        private String wardName;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "department_id", nullable = false)
        private Department department;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;
    }

