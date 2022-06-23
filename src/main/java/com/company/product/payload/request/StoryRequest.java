package com.company.product.payload.request;

import com.company.product.model.StoryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class StoryRequest extends IssueRequest {

    private long estimatedPointValue;

    private StoryStatus status;

}
