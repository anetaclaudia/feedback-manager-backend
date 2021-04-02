package com.feedback.backend.exception;

public class FeedbackCategoryNotFoundException extends RuntimeException{
    public FeedbackCategoryNotFoundException(){

    }
    public FeedbackCategoryNotFoundException(String message){
        super(message);
    }
}
