package com.hospitalmanagement.hospital_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Billing {

        @Id
        @Column(length = 36)
        private String billingId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "patient_id", referencedColumnName = "patientId", nullable = false)
        private Patient patient;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "appointment_id", referencedColumnName = "appointmentId")
        private Appointment appointment;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "lab_test_id", referencedColumnName = "testId")
        private LabTest labTest;

        @Column(precision = 10, scale = 2, nullable = false)
        private BigDecimal amount;

        @Column(nullable = false)
        private LocalDateTime billingDate;

        @Enumerated(EnumType.STRING)
        @Column(length = 20)
        private PaymentStatus paymentStatus = PaymentStatus.Pending;

        @Column(columnDefinition = "TEXT")
        private String notes;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;

        public enum PaymentStatus {
            Pending, Paid, Partially_Paid, Cancelled
        }
}
