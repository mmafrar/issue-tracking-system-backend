package com.company.product.service;

import com.company.product.model.Developer;
import com.company.product.payload.request.DeveloperRequest;
import com.company.product.repository.DeveloperRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

    private static final Logger LOG = LoggerFactory.getLogger(DeveloperService.class);

    @Autowired
    private DeveloperRepository developerRepository;

    public List<Developer> findAll() {
        return developerRepository.findAll();
    }

    public Optional<Developer> findById(int id) {
        return developerRepository.findById(id);
    }

    public Developer save(DeveloperRequest developerRequest) {
        return developerRepository.save(convertDeveloperRequestToDeveloper(developerRequest, new Developer()));
    }

    public Optional<Developer> update(int id, DeveloperRequest developerRequest) {
        Developer developer = developerRepository.findById(id).orElse(null);

        if (developer != null)
            developer = developerRepository.save(convertDeveloperRequestToDeveloper(developerRequest, developer));
        else
            LOG.warn(String.format("No developer details for the given id %d", id));

        return Optional.ofNullable(developer);
    }

    public void deleteById(int id) {
        developerRepository.deleteById(id);
    }

    private Developer convertDeveloperRequestToDeveloper(DeveloperRequest developerRequest, Developer developer) {
        developer.setName(developerRequest.getName());
        return developer;
    }

}
