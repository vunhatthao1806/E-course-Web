/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.ecourse.pojo.Videocomplete;
import com.ecourse.repository.VideoCompleteRepository;
import com.ecourse.service.VideoCompleteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class VideoCompleteServiceImpl implements VideoCompleteService{
    @Autowired
    private VideoCompleteRepository videoCompleteRepo;

    @Override
    public void addVideos(Long userId, Long videoId) {
        this.videoCompleteRepo.addVideos(userId, videoId);
    }

    @Override
    public List<Videocomplete> getVideosCompleted(Long userId) {
        return videoCompleteRepo.getVideosCompleted(userId);
    }
}
