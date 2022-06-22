package com.company.product.payload.request;

import com.company.product.model.StoryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Setter
@Getter
@AllArgsConstructor
public class StoryRequest extends IssueRequest {

    @Min(value = 1, message = "Estimated point value should not be less than 1")
    private long estimatedPointValue;

    private StoryStatus status;

}
