/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.controllers;

import com.ecourse.dto.CategoryDTO;
import com.ecourse.dto.CourseDTO;
import com.ecourse.dto.TagDTO;
import com.ecourse.dto.TeacherDTO;
import com.ecourse.dto.UserDTO;
import com.ecourse.pojo.Course;
import com.ecourse.service.CourseService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiCourseController {

    @Autowired
    private CourseService courseSer;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> list() {
        List<Course> courses = this.courseSer.getCourses();
        List<CourseDTO> courseDTO = convertToDTO(courses);
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/courses/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "courseId") int id) {
        this.courseSer.deleteCourse(id);
    }
    @GetMapping("/courses/search")
    public ResponseEntity<List<CourseDTO>> list(@RequestParam Map<String, String> params) {
        List<Course> courses = this.courseSer.getCourses(params);
        List<CourseDTO> courseDTO = convertToDTO(courses);
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
    }
    private List<CourseDTO> convertToDTO(List<Course> courses) {
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for (Course c : courses) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(c.getId());
            courseDTO.setName(c.getName());
            courseDTO.setPrice(c.getPrice());
            courseDTO.setImage(c.getImage());
            courseDTO.setDiscount(c.getDiscount());
            TagDTO tagDTO = new TagDTO();
            tagDTO.setName(c.getTagId().getName());
            courseDTO.setTag(tagDTO);
            TeacherDTO teacherDTO = new TeacherDTO();
            UserDTO userDTO = new UserDTO();
            CategoryDTO cateDTO = new CategoryDTO();
            courseDTO.setCategory(cateDTO);
            cateDTO.setName(c.getCategoryId().getName());
            userDTO.setFirstName(c.getTeacherId().getUserId().getFirstName());
            userDTO.setLastName(c.getTeacherId().getUserId().getLastName());
            teacherDTO.setUser(userDTO);
            courseDTO.setTeacher(teacherDTO);
            courseDTOList.add(courseDTO);
        }
        
        return courseDTOList;
    }
}
