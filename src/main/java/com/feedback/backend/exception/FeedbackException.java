package com.feedback.backend.exception;

public class FeedbackException extends RuntimeException{
    public FeedbackException(){

    }
    public FeedbackException(String message){
        super(message);
    }

}
