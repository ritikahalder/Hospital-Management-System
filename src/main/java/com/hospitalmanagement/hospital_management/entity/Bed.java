package com.hospitalmanagement.hospital_management.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public class Bed {

        @Id
        private String bedId;

        @Column(length = 20, nullable = false, unique = true)
        private String bedNumber;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ward_id", nullable = false)
        private Ward ward;

        @Enumerated(EnumType.STRING)
        private BedStatus status = BedStatus.Available;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;

        public enum BedStatus {
            Available, Occupied, Maintenance
        }
}
