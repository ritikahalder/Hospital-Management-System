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
@Table(name = "medical_record")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicalRecord {

        @Id
        @Column(length = 36)
        private String recordId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "patient_id", referencedColumnName = "patientId", nullable = false)
        private Patient patient;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "doctor_id", referencedColumnName = "staffId", nullable = false)
        private Staff doctor;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "appointment_id", referencedColumnName = "appointmentId")
        private Appointment appointment;

        @Column(columnDefinition = "TEXT")
        private String diagnosis;

        @Column(columnDefinition = "TEXT")
        private String prescription;

        @Column(columnDefinition = "TEXT")
        private String notes;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;
}
