/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ecourse.pojo.Video;
import com.ecourse.repository.VideoRepository;
import com.ecourse.service.VideoService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class VideoServiceImpl implements VideoService{
     @Autowired
    private VideoRepository videoRepo;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Video> getVideos(Map<String, String> params) {
        return this.videoRepo.getVideos(params);
    }

    @Override
    public List<Video> getVideos() {
        return this.videoRepo.getVideos();
    }

    @Override
    public void addOrUpdate(Video c) {
        if (!c.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(c.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                c.setDescription(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(VideoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.videoRepo.addOrUpdate(c);
    }
    
    @Override
    public Video getVideoById(Long id) {
        return this.videoRepo.getVideoById(id);
    }

    @Override
    public void deleteVideo(Long id) {
        this.videoRepo.deleteVideo(id);
    }

    @Override
    public List<Video> getVideoByLessonId(Long id) {
        return this.videoRepo.getVideoByLessonId(id);
    }
}
