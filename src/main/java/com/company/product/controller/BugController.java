package com.company.product.controller;

import com.company.product.model.Bug;
import com.company.product.payload.request.BugRequest;
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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/bugs")
public class BugController {

    @Autowired
    private BugService bugService;

    @GetMapping
    public ResponseEntity<List<Bug>> findAll() {
        return new ResponseEntity<>(bugService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{issueId}")
    public ResponseEntity findById(@PathVariable int issueId) {
        Optional<Bug> bug = bugService.findById(issueId);
        if (bug.isPresent())
            return new ResponseEntity<>(bug, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Bug> save(@RequestBody @Valid BugRequest bugRequest) {
        return new ResponseEntity<>(bugService.save(bugRequest), HttpStatus.OK);
    }

    @PutMapping("/{issueId}")
    public ResponseEntity update(@PathVariable int issueId, @RequestBody @Valid BugRequest bugRequest) {
        Optional<Bug> bug = bugService.update(issueId, bugRequest);
        if (bug.isPresent())
            return new ResponseEntity<>(bug, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{issueId}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int issueId) {
        bugService.deleteById(issueId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
