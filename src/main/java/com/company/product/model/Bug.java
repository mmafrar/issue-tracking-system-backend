package com.company.product.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Bug extends Issue {

    @Column
    private BugPriority priority;

    @Column
    private BugStatus status = BugStatus.NEW;

}
