package com.feedback.backend.service;

import com.feedback.backend.dto.FeedbackCategoryDto;
import com.feedback.backend.exception.FeedbackCategoryNotFoundException;
import com.feedback.backend.mapper.FeedbackCategoryMapper;
import com.feedback.backend.mapper.FeedbackMapper;
import com.feedback.backend.model.FeedbackCategory;
import com.feedback.backend.repository.FeedbackCategoryRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class FeedbackCategoryService {

    @Autowired
    private FeedbackCategoryRepository feedbackCategoryRepository;

    private FeedbackCategoryMapper feedbackCategoryMapper = Mappers.getMapper(FeedbackCategoryMapper.class);

    public FeedbackCategory findRootCategory() {
        FeedbackCategory feedbackCategory = new FeedbackCategory();
        if (feedbackCategoryRepository.findById(1L).isPresent()) {
            feedbackCategory = feedbackCategoryRepository.findById(1L).get();
        } else {
            throw new FeedbackCategoryNotFoundException("Couldn't find root category.");
        }
        return feedbackCategory;
    }

    public LinkedList<FeedbackCategoryDto> getAllCategoriesInOrder(){
        FeedbackCategory rootCategory = findRootCategory();
        return recursiveCategoryTree(rootCategory);
    }

    public LinkedList<FeedbackCategoryDto> recursiveCategoryTree(FeedbackCategory root){
        LinkedList<FeedbackCategoryDto> feedbackCategoryDtos = new LinkedList<>();
        // Always add root to list
        FeedbackCategoryDto dtoToAdd = feedbackCategoryMapper.feedbackCategoryToFeedbackCategoryDto(root);
        feedbackCategoryDtos.add(dtoToAdd);
        if (!root.getSubCategories().isEmpty()) {
            for (FeedbackCategory child: root.getSubCategories()) {
                feedbackCategoryDtos.addAll(recursiveCategoryTree(child));
            }
        } else dtoToAdd.setDisabled(false);
        return feedbackCategoryDtos;
    }
}
