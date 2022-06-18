package com.company.product.controller;

import com.company.product.model.Bug;
import com.company.product.service.BugService;
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
@RequestMapping("api/v1/bugs")
public class BugController implements IssueController<Bug> {

    @Autowired
    private BugService bugService;

    @Override
    @GetMapping
    public ResponseEntity<List<Bug>> findAll() {
        return new ResponseEntity<>(bugService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        Optional<Bug> bug = bugService.findById(id);
        if (bug.isPresent())
            return new ResponseEntity<>(bug, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @PostMapping
    public ResponseEntity<Bug> save(@RequestBody Bug object) {
        return new ResponseEntity<>(bugService.save(object), HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Bug object) {
        Optional<Bug> bug = bugService.update(id, object);
        if (bug.isPresent())
            return new ResponseEntity<>(bug, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) {
        bugService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
