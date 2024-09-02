/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecourse.repository;

import com.ecourse.pojo.Videocomplete;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface VideoCompleteRepository {
    void addVideos(Long userId, Long videoId);
    List<Videocomplete> getVideosCompleted(Long userId);
}
