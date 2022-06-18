package com.company.product.controller;

import com.company.product.model.Issue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * This interface contains REST APIs for issue
 */
public interface IssueController <T extends Issue> {

    /**
     * This REST endpoint returns all the issues
     * @return ResponseEntity<List<T>>
     */
    ResponseEntity<List<T>> findAll();

    /**
     * This REST endpoint returns an issue for a given id
     * @param id
     * @return ResponseEntity
     */
    ResponseEntity findById(@PathVariable int id);

    /**
     * This REST endpoint saves an issue and returns it
     * @param object
     * @return ResponseEntity<T>
     */
    ResponseEntity<T> save(@RequestBody T object);

    /**
     * This REST endpoint updates an issue for given id
     * @param id
     * @param object
     * @return ResponseEntity
     */
    ResponseEntity update(@PathVariable int id, @RequestBody T object);

    /**
     * This REST endpoint deletes an issue for given id
     * @param id
     * @return ResponseEntity<HttpStatus>
     */
    ResponseEntity<HttpStatus> deleteById(@PathVariable int id);

}
