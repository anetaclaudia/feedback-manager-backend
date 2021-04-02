package com.feedback.backend.dto;

import com.feedback.backend.model.FeedbackCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class FeedbackDto {
    private Long id;
    private String name;
    private String emailAddress;
    private Set<FeedbackCategory> feedbackCategories = new HashSet<>();
    private String text;
}
