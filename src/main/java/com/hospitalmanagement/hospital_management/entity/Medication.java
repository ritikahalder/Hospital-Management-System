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
public class Medication {
        @Id
        @Column(length = 36)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long medicationId;

        @Column(length = 100, nullable = false)
        private String name;

        @Column(length = 50)
        private String dosage;

        @Column(columnDefinition = "TEXT")
        private String description;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;
}
