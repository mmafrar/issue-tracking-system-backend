package com.company.product.service;

import com.company.product.model.Bug;
import com.company.product.model.Developer;
import com.company.product.payload.request.BugRequest;
import com.company.product.repository.BugRepository;
import com.company.product.repository.DeveloperRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * This class contains business logic for bug
 */
@Service
public class BugService {

    private static final Logger LOG = LoggerFactory.getLogger(BugService.class);

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    /**
     * This method returns all the bugs
     * @return List<Bug>
     */
    public List<Bug> findAll() {
        return bugRepository.findAll();
    }

    /**
     * This method returns a bug for a given id
     * @param id
     * @return Optional<Bug>
     */
    public Optional<Bug> findById(int id) {
        return bugRepository.findById(id);
    }

    /**
     * This method saves a bug and returns it
     * @param bugRequest
     * @return Bug
     */
    public Bug save(BugRequest bugRequest) {
        return bugRepository.save(convertBugRequestToBug(bugRequest, new Bug()));
    }

    /**
     * This method updates a bug for given id and returns it
     * @param id
     * @param bugRequest
     * @return Optional<Bug>
     */
    public Optional<Bug> update(int id, BugRequest bugRequest) {
        Bug bug = bugRepository.findById(id).orElse(null);

        if (bug != null)
            bug = bugRepository.save(convertBugRequestToBug(bugRequest, bug));
        else
            LOG.warn(String.format("No bug details for the given id %d", id));

        return Optional.ofNullable(bug);
    }

    /**
     * This method deletes a bug for given id
     * @param id
     */
    public void deleteById(int id) {
        bugRepository.deleteById(id);
    }

    private Bug convertBugRequestToBug(BugRequest bugRequest, Bug bug) {
        bug.setTitle(bugRequest.getTitle());
        bug.setDescription(bugRequest.getDescription());
        bug.setPriority(bugRequest.getPriority());
        if (Objects.nonNull(bugRequest.getStatus())) bug.setStatus(bugRequest.getStatus());
        if (bugRequest.getDeveloperId() != 0) {
            Developer developer = developerRepository.findById(bugRequest.getDeveloperId()).orElseThrow(EntityNotFoundException::new);
            bug.setAssignee(developer);
        }
        return bug;
    }

}
