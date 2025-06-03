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
public class Feedback {


        @Id
        @Column(length = 36)
        private String feedbackId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "patient_id", nullable = false)
        private Patient patient;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "staff_id", nullable = false)
        private Staff staff;

        @Column
        private Integer rating;

        @Column(columnDefinition = "TEXT")
        private String comments;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;
    }

