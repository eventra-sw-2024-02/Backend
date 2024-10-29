package com.example.demo.service;

import com.example.demo.controller.event.request.TagRequest;
import com.example.demo.entity.ActivityEntity;
import com.example.demo.entity.Event;
import com.example.demo.entity.TagEntity;
import com.example.demo.repository.TagRepository; // Asegúrate de tener este repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;


    public TagEntity createTag(TagEntity tagEntity) {
        return tagRepository.save(tagEntity);
    }

    public List<TagEntity> getAllTags() {
        return tagRepository.findAll();
    }

    public Optional<TagEntity> getTagById(Long id) {
        return tagRepository.findById(id);
    }

    public List<TagEntity> guardarMuchos(List<String> tags, ActivityEntity activity) {
        List<TagEntity> listaTags = new ArrayList<TagEntity>();
        for (String tag : tags) {
            TagEntity tagEntity = new TagEntity();
            tagEntity.setNameTag(tag);
            tagEntity.setActivity(activity);
            listaTags.add(tagEntity);
        }
        return tagRepository.saveAll(listaTags);
    }

    public List<String> getAllTagsByEventId(Long activityId) {
        List<TagEntity> tags= tagRepository.findByActivity_Id(activityId);
        List<String> tagList= new ArrayList<>();
        for (TagEntity tagEntity : tags) {
            tagList.add(tagEntity.getNameTag());
        }
        return tagList;
    }



}
