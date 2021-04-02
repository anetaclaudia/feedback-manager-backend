package com.feedback.backend.mapper;

import com.feedback.backend.dto.FeedbackDto;
import com.feedback.backend.model.Feedback;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FeedbackMapper {
    FeedbackDto feedbackToFeedbackDto(Feedback feedback);
    List<FeedbackDto> feedbacksToDto(List<Feedback> feedbacks);
}
