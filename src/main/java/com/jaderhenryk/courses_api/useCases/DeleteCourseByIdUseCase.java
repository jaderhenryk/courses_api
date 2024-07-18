package com.jaderhenryk.courses_api.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaderhenryk.courses_api.repositories.CourseRepository;

@Service
public class DeleteCourseByIdUseCase {
    
    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID id) {
        this.courseRepository.deleteById(id);
    }
}
