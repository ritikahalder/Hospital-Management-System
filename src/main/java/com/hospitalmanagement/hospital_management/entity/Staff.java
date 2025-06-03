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
    public class Staff {
        @Id
        @Column(length = 36)
        private String staffId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "person_id", nullable = false)
        private User user;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "staff_type_id", nullable = false)
        private StaffType staffType;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "staff_category_id", nullable = false)
        private StaffCategory staffCategory;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "staff_grade_id", nullable = false)
        private StaffGrade staffGrade;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "department_id", nullable = false)
        private Department department;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;
}
