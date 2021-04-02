package com.feedback.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackCategoryDto {
    private Long id;

    private String name;

    private int level;

    private boolean disabled = true;

    @Override
    public String toString() {
        return id + name + level;
    }
}
