package com.company.product.repository;

import com.company.product.model.Story;
import com.company.product.model.StoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer> {

    List<Story> findByStatus(StoryStatus status);

}
