package com.company.product.service;

import com.company.product.model.Bug;
import com.company.product.repository.BugRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugService implements IssueService<Bug> {

    private static final Logger LOG = LoggerFactory.getLogger(BugService.class);

    @Autowired
    private BugRepository bugRepository;

    @Override
    public List<Bug> findAll() {
        return bugRepository.findAll();
    }

    @Override
    public Optional<Bug> findById(int id) {
        return bugRepository.findById(id);
    }

    @Override
    public Bug save(Bug object) {
        return bugRepository.save(object);
    }

    @Override
    public Optional<Bug> update(int id, Bug object) {
        Bug updatedBug = bugRepository.findById(id).orElse(null);
        if(updatedBug != null) {
            updatedBug.setTitle(object.getTitle());
            updatedBug.setDescription(object.getDescription());
            updatedBug.setPriority(object.getPriority());
            updatedBug.setStatus(object.getStatus());
            updatedBug = bugRepository.save(updatedBug);
        } else {
            LOG.warn(String.format("No bug details for the given id %d", id));
        }
        return Optional.ofNullable(updatedBug);
    }

    @Override
    public void deleteById(int id) {
        bugRepository.deleteById(id);
    }

}
