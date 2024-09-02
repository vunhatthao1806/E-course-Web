/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.repository;

import com.ecourse.pojo.Lesson;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface LessonRepository {
    List<Lesson> getLessons(Map<String, String> params);
    List<Lesson> getLessons();
    void addOrUpdate(Lesson c);
    Lesson getLessonById(int id);
    void deleteLesson(int id);
    List<Lesson> getLessonsByCourseId(Long courseId);
}
