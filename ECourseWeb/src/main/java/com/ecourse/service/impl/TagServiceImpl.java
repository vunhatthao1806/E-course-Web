/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.service.impl;

import com.ecourse.pojo.Tag;
import com.ecourse.repository.TagRepository;
import com.ecourse.service.TagService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TagServiceImpl implements TagService{
     @Autowired
    private TagRepository tagRepo;
    @Override
    public List<Tag> getTags() {
        return this.tagRepo.getTags();
    }
    
}
