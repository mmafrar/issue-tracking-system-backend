package com.company.product.payload.request;

import com.company.product.model.BugPriority;
import com.company.product.model.BugStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
public class BugRequest extends IssueRequest {

    @NotNull
    private BugPriority priority;

    private BugStatus status;

}
