package com.company.product.service;

import com.company.product.model.Bug;
import com.company.product.model.Developer;
import com.company.product.repository.DeveloperRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private static final Logger LOG = LoggerFactory.getLogger(DeveloperServiceImpl.class);

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public List<Developer> findAll() {
        return developerRepository.findAll();
    }

    @Override
    public Optional<Developer> findById(int id) {
        return developerRepository.findById(id);
    }

    @Override
    public Developer save(Developer entity) {
        return developerRepository.save(entity);
    }

    @Override
    public Optional<Developer> update(int id, Developer entity) {
        Developer updatedDeveloper = developerRepository.findById(id).orElse(null);
        if(updatedDeveloper != null) {
            updatedDeveloper.setName(entity.getName());
            updatedDeveloper = developerRepository.save(updatedDeveloper);
        } else {
            LOG.warn(String.format("No developer details for the given id %d", id));
        }
        return Optional.ofNullable(updatedDeveloper);
    }

    @Override
    public void deleteById(int id) {
        developerRepository.deleteById(id);
    }

}
