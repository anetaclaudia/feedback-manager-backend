package com.feedback.backend.controller;

import com.feedback.backend.dto.FeedbackDto;
import com.feedback.backend.mapper.FeedbackMapper;
import com.feedback.backend.model.Feedback;
import com.feedback.backend.service.FeedbackService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    private final FeedbackMapper mapper = Mappers.getMapper(FeedbackMapper.class);

    @GetMapping
    public List<FeedbackDto> getFeedbacks(){
        return mapper.feedbacksToDto(feedbackService.findAll());
    }

    @PostMapping
    public FeedbackDto saveFeedback(@RequestBody Feedback feedback){
        return mapper.feedbackToFeedbackDto(feedbackService.save(feedback));
    }
}
