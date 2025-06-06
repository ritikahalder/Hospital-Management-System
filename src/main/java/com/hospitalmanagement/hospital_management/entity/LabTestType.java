package com.hospitalmanagement.hospital_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LabTestType {

        @Id
        @Column(length = 36)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long testTypeId;

        @Column(length = 100, nullable = false)
        private String name;

        @Column(columnDefinition = "TEXT")
        private String description;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;
}
