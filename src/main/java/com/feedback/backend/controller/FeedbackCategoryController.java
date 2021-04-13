package com.feedback.backend.controller;

import com.feedback.backend.dto.FeedbackCategoryDto;
import com.feedback.backend.service.FeedbackCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class FeedbackCategoryController {

    @Autowired
    private FeedbackCategoryService feedbackCategoryService;

    @GetMapping
    public List<FeedbackCategoryDto> getAllFeedbackCategories(){
        return feedbackCategoryService.getAllCategoriesInOrder();
    }
}
