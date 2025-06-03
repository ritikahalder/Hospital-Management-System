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
public class Appoinment {

        @Id
        @Column(length = 36)
        private String appointmentId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "patientId", nullable = false)
        private Patient patient;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "doctor_id", nullable = false)
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
