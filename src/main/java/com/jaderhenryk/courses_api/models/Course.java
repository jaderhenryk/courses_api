package com.jaderhenryk.courses_api.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "course")
@Table(uniqueConstraints = {
    @UniqueConstraint(
        name = "nameAndCategoryUnique",
        columnNames = { "name", "category" }
    )
})
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Please inform the course name")
    @Length(min = 6, message = "The course name must have at least 6 characters.")
    private String name;

    @NotBlank(message = "Please inform the course category")
    @Length(min = 3, message = "The course category must have at least 3 characters.")
    private String category;

    private boolean active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
