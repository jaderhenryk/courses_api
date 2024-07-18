package com.jaderhenryk.courses_api.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaderhenryk.courses_api.models.Course;
import com.jaderhenryk.courses_api.repositories.CourseRepository;

@Service
public class FindCourseByIdUseCase {
    
    @Autowired
    private CourseRepository courseRepository;

    public Course execute(UUID id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        return optionalCourse.orElse(null);
    }
}
