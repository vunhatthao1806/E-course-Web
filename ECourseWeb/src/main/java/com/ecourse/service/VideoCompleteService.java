/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ecourse.service;

import com.ecourse.pojo.Videocomplete;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface VideoCompleteService {
    void addVideos(Long userId, Long videoId);
    List<Videocomplete> getVideosCompleted(Long userId);
}
