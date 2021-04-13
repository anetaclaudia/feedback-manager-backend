package com.feedback.backend.service;

import com.feedback.backend.exception.FeedbackException;
import com.feedback.backend.model.Feedback;
import com.feedback.backend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    public Feedback save(Feedback feedback) {
        Feedback savedFeedback = new Feedback();
        if (!validateName(feedback.getName()) && validateEmailAddress(feedback.getEmailAddress())){
            return feedbackRepository.save(savedFeedback);
        } else {
            throw new FeedbackException("Name or email is not in correct format.");
        }
    }

    /**
     * Helper method for finding out if name is in correct format.
     * Regex pattern includes unicodes of common characters in Estonian, such as õ, ä, ö, ü, ž, š
     * Main rules for the name format - exclude all the special character, i.e. such as {}, ! or @.
     * Exceptions - name can consist whitespace or hyphen.
     *
     * @param name - from feedback form
     * @return boolean - if it returns false, then it means there are no special characters
     */
    public boolean validateName(String name) {
        Pattern pattern = Pattern.compile("[^\\u00f5\\u00d5\\u00e4\\u00c4\\u00f6\\u00d6\\u00fc\\u00dc\\u0161\\u0160" +
                "\\u017e\\u017da-zA-Z\\s-]");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    /**
     * Helper method for finding out if email address is in correct format.
     * Main rule is that no special characters are allowed, except for ".", "_" and @. And email address domain name
     * has to be at least 2 characters long and letters are in lowercase.
     *
     * @param emailAddress - email address string from feedback form
     * @return boolean - if it returns true, then it means the email address is in correct format
     */
    public boolean validateEmailAddress(String emailAddress) {
        Pattern pattern = Pattern.compile("[0-9a-zA-Z._-]+@[0-9a-zA-Z._-]+.[a-z]{2,}");
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.find();
    }
}
