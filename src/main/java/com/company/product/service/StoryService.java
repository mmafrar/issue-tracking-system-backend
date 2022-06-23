package com.company.product.service;

import com.company.product.model.Story;
import com.company.product.model.StoryStatus;
import com.company.product.payload.request.StoryRequest;
import com.company.product.repository.DeveloperRepository;
import com.company.product.repository.StoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * This class contains business logic for story
 */
@Service
public class StoryService {

    private static final Logger LOG = LoggerFactory.getLogger(StoryService.class);

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    /**
     * This method returns all the stories
     * @return List<Story>
     */
    public List<Story> findAll() {
        return storyRepository.findAll();
    }

    /**
     * This method returns a story for a given id
     * @param id
     * @return Optional<Story>
     */
    public Optional<Story> findById(int id) {
        return storyRepository.findById(id);
    }

    /**
     * This method returns the plan for the estimated stories
     * @return Map<String,List<Story>>
     */
    public Map<String,List<Story>> plan() {
        int week = 0;
        Map<String,List<Story>> storyPlan = new HashMap<>();
        long storyPointsPerWeek = developerRepository.count() * 10;
        // Made an assumption that only estimated stories will be considered for the plan
        List<Story> estimatedStories = storyRepository.findByStatus(StoryStatus.ESTIMATED);

        while (!estimatedStories.isEmpty()) {
            long storyPoints = 0;
            List<Story> weeklyStories = new ArrayList<>();
            while (storyPoints < storyPointsPerWeek) {
                long finalStoryPoints = storyPoints;
                Optional<Story> story = estimatedStories.stream()
                        .filter(s -> s.getEstimatedPointValue() <= (storyPointsPerWeek - finalStoryPoints))
                        .max(Comparator.comparing(Story::getEstimatedPointValue));
                if (!story.isPresent() || (storyPoints + story.get().getEstimatedPointValue()) > storyPointsPerWeek) break;
                storyPoints += story.get().getEstimatedPointValue();
                LOG.debug(estimatedStories.toString());
                estimatedStories.remove(story.get());
                weeklyStories.add(story.get());
            }
            week++;
            storyPlan.put("Week " + week, weeklyStories);
        }

        return storyPlan;
    }

    /**
     * This method saves a story and returns it
     * @param storyRequest
     * @return Story
     */
    public Story save(StoryRequest storyRequest) {
        return storyRepository.save(convertStoryRequestToStory(storyRequest, new Story()));
    }

    /**
     * This method updates a story for given id and returns it
     * @param id
     * @param storyRequest
     * @return Optional<Story>
     */
    public Optional<Story> update(int id, StoryRequest storyRequest) {
        Story story = storyRepository.findById(id).orElse(null);

        if (story != null)
            story = storyRepository.save(convertStoryRequestToStory(storyRequest, story));
        else
            LOG.warn(String.format("No story details for the given id %d", id));

        return Optional.ofNullable(story);
    }

    /**
     * This method deletes a story for given id
     * @param id
     */
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
