package com.jaderhenryk.courses_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jaderhenryk.courses_api.models.Course;
import com.jaderhenryk.courses_api.models.dto.UpdateCourseRequest;
import com.jaderhenryk.courses_api.useCases.CreateCourseUseCase;
import com.jaderhenryk.courses_api.useCases.DeleteCourseByIdUseCase;
import com.jaderhenryk.courses_api.useCases.FindCoursesByNameOrCategoryUseCase;
import com.jaderhenryk.courses_api.useCases.ToggleCourseActiveUseCase;
import com.jaderhenryk.courses_api.useCases.UpdateCourseUseCase;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private FindCoursesByNameOrCategoryUseCase findCoursesByNameOrCategoryUseCase;

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private DeleteCourseByIdUseCase deleteCourseByIdUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private ToggleCourseActiveUseCase toggleCourseActiveUseCase;
    
    @GetMapping()
    public ResponseEntity<Object> findByFilter(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String category
        ) {
        var results = this.findCoursesByNameOrCategoryUseCase.execute(name, category);
        return ResponseEntity.ok().body(results);
    }
    
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody Course course) {
        try {
            var result = this.createCourseUseCase.execute(course);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            this.deleteCourseByIdUseCase.execute(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody UpdateCourseRequest request) {
        try {
            this.updateCourseUseCase.execute(id, request);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/toggleActive")
    public ResponseEntity<Object> toggleActive(@PathVariable UUID id) {
         try {
            this.toggleCourseActiveUseCase.execute(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
         }
    }
}
