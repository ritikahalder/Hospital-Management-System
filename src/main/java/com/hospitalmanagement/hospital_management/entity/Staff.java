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
        @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
        private User user;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "staff_type_id", referencedColumnName = "staffId", nullable = false)
        private StaffType staffType;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "staff_category_id", referencedColumnName = "staffCategoryId", nullable = false)
        private StaffCategory staffCategory;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "staff_grade_id", referencedColumnName = "staffGradeId", nullable = false)
        private StaffGrade staffGrade;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "department_id", referencedColumnName = "departmentId", nullable = false)
        private Department department;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;
}
