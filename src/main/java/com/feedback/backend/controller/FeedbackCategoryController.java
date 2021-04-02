package com.feedback.backend.controller;

import com.feedback.backend.dto.FeedbackCategoryDto;
import com.feedback.backend.dto.FeedbackDto;
import com.feedback.backend.service.FeedbackCategoryService;
import com.feedback.backend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("category")
public class FeedbackCategoryController {

    @Autowired
    private FeedbackCategoryService feedbackCategoryService;

    @GetMapping
    public LinkedList<FeedbackCategoryDto> getAllFeedbackCategories(){
        return feedbackCategoryService.getAllCategoriesInOrder();
    }
}
