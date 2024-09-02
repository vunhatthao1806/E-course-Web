/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
public class CourseDTO {

    private Long id;
    private String name;
    private float price;
    private String image;
    private float discount;
    private TeacherDTO teacher;
    private TagDTO tag;
    private CategoryDTO category;
    private String description;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
    @JsonIgnore
    private MultipartFile file;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

//    /**
//     * @return the teacher
//     */
//    public TeacherDTO getTeacher() {
//        return teacher;
//    }
//
//    /**
//     * @param teacher the teacher to set
//     */
//    public void setTeacher(TeacherDTO teacher) {
//        this.teacher = teacher;
//    }
    /**
     * @return the tag
     */
    public TagDTO getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(TagDTO tag) {
        this.tag = tag;
    }

    /**
     * @return the discount
     */
    public float getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    /**
     * @return the teacher
     */
    public TeacherDTO getTeacher() {
        return teacher;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    /**
     * @return the category
     */
    public CategoryDTO getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the updatedDate
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate the updatedDate to set
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
