package com.example.demo.service;

import com.example.demo.controller.event.request.TagRequest;
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

    public List<TagEntity> guardarMuchos(List<TagRequest> tags, Event event) {
        List<TagEntity> listaTags = new ArrayList<TagEntity>();
        for (TagRequest tag : tags) {
            TagEntity tagEntity = new TagEntity();
            tagEntity.setNameTag(tag.nameTag());
            tagEntity.setEvent(event);
            listaTags.add(tagEntity);
        }
        return tagRepository.saveAll(listaTags);
    }

    public List<TagEntity> getAllTagsByEventId(Long eventId) {
        return tagRepository.findByEvent_Id(eventId);
    }

}
