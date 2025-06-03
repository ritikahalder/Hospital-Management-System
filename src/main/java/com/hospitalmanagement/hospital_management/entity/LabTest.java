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
public class LabTest {

        @Id
        @Column(length = 36)
        private String testId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "patient_id", nullable = false)
        private Patient patient;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "doctor_id", nullable = false)
        private Staff doctor;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "test_type_id", nullable = false)
        private Labtesttype testType;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "appointmentId")
        private Appoinment appointment;

        @Column(nullable = false)
        private LocalDateTime testDate;

        @Column(columnDefinition = "TEXT")
        private String result;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;
    }

