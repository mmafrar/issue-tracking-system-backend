package com.company.product.service;

import com.company.product.model.Story;
import com.company.product.payload.request.StoryRequest;
import com.company.product.repository.StoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StoryService {

    private static final Logger LOG = LoggerFactory.getLogger(StoryService.class);

    @Autowired
    private StoryRepository storyRepository;

    public List<Story> findAll() {
        return storyRepository.findAll();
    }

    public Optional<Story> findById(int id) {
        return storyRepository.findById(id);
    }

    public Story save(StoryRequest storyRequest) {
        return storyRepository.save(convertStoryRequestToStory(storyRequest, new Story()));
    }

    public Optional<Story> update(int id, StoryRequest storyRequest) {
        Story story = storyRepository.findById(id).orElse(null);

        if (story != null)
            story = storyRepository.save(convertStoryRequestToStory(storyRequest, story));
        else
            LOG.warn(String.format("No story details for the given id %d", id));

        return Optional.ofNullable(story);
    }

    public void deleteById(int id) {
        storyRepository.deleteById(id);
    }

    private Story convertStoryRequestToStory(StoryRequest storyRequest, Story story) {
        story.setTitle(storyRequest.getTitle());
        story.setDescription(storyRequest.getDescription());
        story.setEstimatedPointValue(storyRequest.getEstimatedPointValue());
        if (Objects.nonNull(storyRequest.getStatus())) story.setStatus(storyRequest.getStatus());
        return story;
    }

}
