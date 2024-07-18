package com.jaderhenryk.courses_api.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaderhenryk.courses_api.models.Course;
import com.jaderhenryk.courses_api.repositories.CourseRepository;

@Service
public class ToggleCourseActiveUseCase {
    
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private FindCourseByIdUseCase findCourseByIdUseCase;

    public void execute(UUID id) {
        Course course = this.findCourseByIdUseCase.execute(id);
        if (course != null) {
            boolean isActive = course.isActive();
            course.setActive(!isActive);
            this.courseRepository.save(course);
        }
    }
}
