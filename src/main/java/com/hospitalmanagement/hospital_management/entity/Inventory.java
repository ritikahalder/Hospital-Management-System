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
public class Inventory {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long inventoryId;

        @Column(length = 100, nullable = false)
        private String name;

        @Column(length = 50)
        private String category;

        @Column(nullable = false)
        private Integer quantity;

        @Column(length = 20)
        private String unit;

        private LocalDate expiryDate;

        @Column(length = 100)
        private String supplier;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;
}
