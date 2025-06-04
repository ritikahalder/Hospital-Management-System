package com.hospitalmanagement.hospital_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
    public class Patient {
        @Id
        @Column(length = 36)
        private String patientId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
        private User user   ;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "admitted_by", referencedColumnName = "staffId")
        private Staff admittedBy;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "supervised_by", referencedColumnName = "staffId")
        private Staff supervisedBy;

        private LocalDate admittedDate;

        private LocalDate dischargedDate;

        @Enumerated(EnumType.STRING)
        @Column(length = 20)
        private PatientStatus status = PatientStatus.Active;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;

        public enum PatientStatus {
            Active, Discharged, Transferred, Deceased
        }
    }
