/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.controllers;

import com.ecourse.pojo.Course;
import com.ecourse.service.CourseService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class CourseController {

    @Autowired
    private CourseService courseSer;

    @GetMapping("/courses")
    public String viewCourse(Model model) {
        model.addAttribute("course", new Course());
        return "course";
    }

    @GetMapping("/courses/{courseId}")
    public String courseView(Model model, @PathVariable(value = "courseId") int id) {
        model.addAttribute("course", this.courseSer.getCourseById(id));
        return "course";
    }

    @PostMapping("/courses")
    public String createView(Model model, @ModelAttribute(value = "course") @Valid Course c,
            BindingResult rs) {
        if (rs.hasErrors()) {
            if (rs.hasErrors()) {
                model.addAttribute("errorMessage", "Vui lòng kiểm tra lại thông tin đã nhập");
                return "course";
            }
            try {
                this.courseSer.addOrUpdate(c);
            } catch (Exception e) {
                model.addAttribute("errorMessage", "Lỗi khi lưu khóa học, vui lòng thử lại.");
                return "course";
            }
            this.courseSer.addOrUpdate(c);
        }
        return "redirect:/";
    }

}
