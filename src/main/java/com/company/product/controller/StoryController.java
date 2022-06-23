package com.company.product.controller;

import com.company.product.model.Story;
import com.company.product.payload.request.StoryRequest;
import com.company.product.service.StoryService;
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
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/stories")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping
    public ResponseEntity<List<Story>> findAll() {
        return new ResponseEntity<>(storyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{issueId}")
    public ResponseEntity findById(@PathVariable int issueId) {
        Optional<Story> story = storyService.findById(issueId);
        if (story.isPresent())
            return new ResponseEntity<>(story, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/plan")
    public ResponseEntity<Map<String,List<Story>>> plan() {
        return new ResponseEntity<>(storyService.plan(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Story> save(@RequestBody @Valid StoryRequest storyRequest) {
        return new ResponseEntity<>(storyService.save(storyRequest), HttpStatus.OK);
    }

    @PutMapping("/{issueId}")
    public ResponseEntity update(@PathVariable int issueId, @RequestBody @Valid StoryRequest storyRequest) {
        Optional<Story> story = storyService.update(issueId, storyRequest);
        if (story.isPresent())
            return new ResponseEntity<>(story, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{issueId}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int issueId) {
        storyService.deleteById(issueId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
