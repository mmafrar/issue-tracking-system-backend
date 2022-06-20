package com.company.product.controller;

import com.company.product.model.Bug;
import com.company.product.payload.request.BugRequest;
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
@RequestMapping("api/v1/bugs")
public class BugController {

    @Autowired
    private IssueService<Bug> bugService;

    @GetMapping
    public ResponseEntity<List<Bug>> findAll() {
        return new ResponseEntity<>(bugService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        Optional<Bug> bug = bugService.findById(id);
        if (bug.isPresent())
            return new ResponseEntity<>(bug, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Bug> save(@RequestBody @Valid BugRequest bugRequest) {
        return new ResponseEntity<>(bugService.save(convertBugRequestToBug(bugRequest)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody @Valid BugRequest bugRequest) {
        Optional<Bug> bug = bugService.update(id, convertBugRequestToBug(bugRequest));
        if (bug.isPresent())
            return new ResponseEntity<>(bug, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) {
        bugService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Bug convertBugRequestToBug(BugRequest bugRequest) {
        Bug bug = new Bug();
        bug.setTitle(bugRequest.getTitle());
        bug.setDescription(bugRequest.getDescription());
        bug.setPriority(bugRequest.getPriority());
        if (Objects.nonNull(bugRequest.getStatus())) bug.setStatus(bugRequest.getStatus());
        return bug;
    }

}
