package com.feedback.backend.mapper;

import com.feedback.backend.dto.FeedbackCategoryDto;
import com.feedback.backend.model.FeedbackCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FeedbackCategoryMapper {
    FeedbackCategoryDto feedbackCategoryToFeedbackCategoryDto(FeedbackCategory feedbackCategory);
    List<FeedbackCategoryDto> feedbackCategoriesToDto(List<FeedbackCategory> feedbackCategories);
}
