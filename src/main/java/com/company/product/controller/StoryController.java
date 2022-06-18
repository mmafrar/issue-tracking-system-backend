package com.company.product.controller;

import com.company.product.model.Story;
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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/stories")
public class StoryController implements IssueController<Story> {

    @Autowired
    private StoryService storyService;

    @Override
    @GetMapping
    public ResponseEntity<List<Story>> findAll() {
        return new ResponseEntity<>(storyService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        Optional<Story> story = storyService.findById(id);
        if (story.isPresent())
            return new ResponseEntity<>(story, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @PostMapping
    public ResponseEntity<Story> save(@RequestBody Story object) {
        return new ResponseEntity<>(storyService.save(object), HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Story object) {
        Optional<Story> story = storyService.update(id, object);
        if (story.isPresent())
            return new ResponseEntity<>(story, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) {
        storyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
