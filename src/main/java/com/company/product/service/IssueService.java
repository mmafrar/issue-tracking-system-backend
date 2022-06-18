package com.company.product.service;

import com.company.product.model.Issue;

import java.util.List;
import java.util.Optional;

/**
 * This interface contains business logic for issue
 */
public interface IssueService<T extends Issue> {

    /**
     * This method returns all the issues
     * @return List<T>
     */
    List<T> findAll();

    /**
     * This method returns an issue for a given id
     * @param id
     * @return Optional<T>
     */
    Optional<T> findById(int id);

    /**
     * This method saves an issue and returns it
     * @param object
     * @return T
     */
    T save(T object);

    /**
     * This method updates an issue for given id
     * @param id
     * @param object
     * @return T
     */
    Optional<T> update(int id, T object);

    /**
     * This method deletes an issue for given id
     * @param id
     */
    void deleteById(int id);

}