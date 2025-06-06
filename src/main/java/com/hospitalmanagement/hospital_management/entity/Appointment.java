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
public class Appointment {

        @Id
        @Column(length = 36)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long appointmentId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "patient_id", referencedColumnName = "patientId", nullable = false)
        private Patient patient;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "doctor_id", referencedColumnName = "staffId", nullable = false)
        private Staff doctor;

        @Column(nullable = false)
        private LocalDateTime appointmentDate;

        @Enumerated(EnumType.STRING)
        @Column(length = 20)
        private AppointmentStatus status = AppointmentStatus.Scheduled;

        @Column(columnDefinition = "TEXT")
        private String notes;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;

        public enum AppointmentStatus {
            Scheduled, Completed, Cancelled, NoShow
        }
}
