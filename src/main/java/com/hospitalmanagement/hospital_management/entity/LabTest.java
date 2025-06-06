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
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long testId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "patient_id", referencedColumnName = "patientId", nullable = false)
        private Patient patient;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "doctor_id", referencedColumnName = "staffId", nullable = false)
        private Staff doctor;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "test_type_id", referencedColumnName = "testTypeId", nullable = false)
        private LabTestType testType;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "appointment_Id", referencedColumnName = "appointmentId")
        private Appointment appointment;

        @Column(nullable = false)
        private LocalDateTime testDate;

        @Column(columnDefinition = "TEXT")
        private String result;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;
    }

