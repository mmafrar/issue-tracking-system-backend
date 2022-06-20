package com.company.product.controller;

import com.company.product.model.Story;
import com.company.product.payload.request.StoryRequest;
import com.company.product.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/stories")
public class StoryController {

    @Autowired
    private IssueService<Story> storyService;

    @GetMapping
    public ResponseEntity<List<Story>> findAll() {
        return new ResponseEntity<>(storyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        Optional<Story> story = storyService.findById(id);
        if (story.isPresent())
            return new ResponseEntity<>(story, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Story> save(@RequestBody @Valid StoryRequest storyRequest) {
        return new ResponseEntity<>(storyService.save(convertStoryRequestToStory(storyRequest)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody @Valid StoryRequest storyRequest) {
        Optional<Story> story = storyService.update(id, convertStoryRequestToStory(storyRequest));
        if (story.isPresent())
            return new ResponseEntity<>(story, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) {
        storyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Story convertStoryRequestToStory(StoryRequest storyRequest) {
        Story story = new Story();
        story.setTitle(storyRequest.getTitle());
        story.setDescription(storyRequest.getDescription());
        story.setEstimatedPointValue(storyRequest.getEstimatedPointValue());
        if (Objects.nonNull(storyRequest.getStatus())) story.setStatus(storyRequest.getStatus());
        return story;
    }

}
