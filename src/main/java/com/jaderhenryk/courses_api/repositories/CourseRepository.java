package com.jaderhenryk.courses_api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaderhenryk.courses_api.models.Course;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    
    @Query("SELECT c FROM course c " +
           "WHERE (:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
           "AND (:category IS NULL OR LOWER(c.category) LIKE LOWER(CONCAT('%', :category, '%')))")
    List<Course> findByNameOrCategoryIgnoreCase(@Param("name") String name, @Param("category") String category);

    @Query("UPDATE course c SET c.name = :name WHERE c.id = :id")
    void updateCourseNameById(UUID id, String name); 
    
    @Query("UPDATE course c SET c.category = :category WHERE c.id = :id")
    void updateCourseCategoryById(UUID id, String category);
    
    @Query("UPDATE course c SET c.category = :category, c.name = :name WHERE c.id = :id")
    void updateCourseById(UUID id, String name, String category);
}
