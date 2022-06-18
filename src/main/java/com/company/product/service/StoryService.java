package com.company.product.service;

import com.company.product.model.Story;
import com.company.product.repository.StoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoryService implements IssueService<Story> {

    private static final Logger LOG = LoggerFactory.getLogger(StoryService.class);

    @Autowired
    private StoryRepository storyRepository;

    @Override
    public List<Story> findAll() {
        return storyRepository.findAll();
    }

    @Override
    public Optional<Story> findById(int id) {
        return storyRepository.findById(id);
    }

    @Override
    public Story save(Story object) {
        return storyRepository.save(object);
    }

    @Override
    public Optional<Story> update(int id, Story object) {
        Story updatedStory = storyRepository.findById(id).orElse(null);
        if (updatedStory != null) {
            updatedStory.setTitle(object.getTitle());
            updatedStory.setDescription(object.getDescription());
            updatedStory.setEstimatedPointValue(object.getEstimatedPointValue());
            updatedStory.setStatus(object.getStatus());
            updatedStory = storyRepository.save(updatedStory);
        } else {
            LOG.warn(String.format("No story details for the given id %d", id));
        }
        return Optional.ofNullable(updatedStory);
    }

    @Override
    public void deleteById(int id) {
        storyRepository.deleteById(id);
    }

}
