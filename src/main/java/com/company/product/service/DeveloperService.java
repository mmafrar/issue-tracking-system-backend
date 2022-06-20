package com.company.product.service;

import com.company.product.model.Developer;

import java.util.List;
import java.util.Optional;

/**
 * This interface contains business logic for developer
 */
public interface DeveloperService {

    /**
     * This method returns all the developers
     * @return List<Developer>
     */
    List<Developer> findAll();

    /**
     * This method returns a developer for a given id
     * @param id
     * @return Optional<Developer>
     */
    Optional<Developer> findById(int id);

    /**
     * This method saves a developer and returns it
     * @param entity
     * @return Developer
     */
    Developer save(Developer entity);

    /**
     * This method updates a developer for given id
     * @param id
     * @param entity
     * @return Optional<Developer>
     */
    Optional<Developer> update(int id, Developer entity);

    /**
     * This method deletes a developer for given id
     * @param id
     */
    void deleteById(int id);

}
