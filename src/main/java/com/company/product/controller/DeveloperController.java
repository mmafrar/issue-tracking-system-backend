package com.company.product.controller;

import com.company.product.model.Developer;
import com.company.product.payload.request.DeveloperRequest;
import com.company.product.service.DeveloperService;
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
@RequestMapping("api/v1/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @GetMapping
    public ResponseEntity<List<Developer>> findAll() {
        return new ResponseEntity<>(developerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{developerId}")
    public ResponseEntity findById(@PathVariable int developerId) {
        Optional<Developer> developer = developerService.findById(developerId);
        if (developer.isPresent())
            return new ResponseEntity<>(developer, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Developer> save(@RequestBody @Valid DeveloperRequest developerRequest) {
        return new ResponseEntity<>(developerService.save(developerRequest), HttpStatus.OK);
    }

    @PutMapping("/{developerId}")
    public ResponseEntity update(@PathVariable int developerId, @RequestBody @Valid DeveloperRequest developerRequest) {
        Optional<Developer> developer = developerService.update(developerId, developerRequest);
        if (developer.isPresent())
            return new ResponseEntity<>(developer, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{developerId}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int developerId) {
        developerService.deleteById(developerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
