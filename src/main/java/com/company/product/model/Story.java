package com.company.product.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Story extends Issue {

    @Column
    private long estimatedPointValue;

    @Column
    private StoryStatus status = StoryStatus.NEW;

}
