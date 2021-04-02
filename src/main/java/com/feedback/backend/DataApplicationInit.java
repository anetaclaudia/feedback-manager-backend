package com.feedback.backend;

import com.feedback.backend.model.Feedback;
import com.feedback.backend.model.FeedbackCategory;
import com.feedback.backend.repository.FeedbackCategoryRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

;import java.util.*;

@Component
public class DataApplicationInit implements CommandLineRunner {

    @Autowired
    private FeedbackCategoryRepository feedbackCategoryRepository;

    @SneakyThrows
    @Override
    public void run(String... args) {
        List<FeedbackCategory> categories = new ArrayList<>();
        FeedbackCategory application = new FeedbackCategory(1L, "Application", 0, null, Collections.emptyList());
        FeedbackCategory health = new FeedbackCategory(2L, "Health", 1, application, Collections.emptyList());
        FeedbackCategory documentManagement = new FeedbackCategory(3L, "Document management", 1, application, Collections.emptyList());
        FeedbackCategory patientsPortal = new FeedbackCategory(4L, "Patients portal", 2, health, Collections.emptyList());
        FeedbackCategory doctorsPortal = new FeedbackCategory(5L, "Doctors portal", 2, health, Collections.emptyList());
        FeedbackCategory remoteVisitPortal = new FeedbackCategory(6L, "Remote visit portal", 2, health, Collections.emptyList());
        FeedbackCategory registration = new FeedbackCategory(7L, "Registration", 3, remoteVisitPortal, Collections.emptyList());
        FeedbackCategory virtualVisit = new FeedbackCategory(8L, "Virtual visit", 3, remoteVisitPortal, Collections.emptyList());
        FeedbackCategory openKM = new FeedbackCategory(9L, "OpenKM", 2, documentManagement, Collections.emptyList());
        FeedbackCategory microsoftSharepoint = new FeedbackCategory(10L, "Microsoft Sharepoint", 2, documentManagement, Collections.emptyList());

        categories.add(application);
        categories.add(health);
        categories.add(documentManagement);
        categories.add(patientsPortal);
        categories.add(doctorsPortal);
        categories.add(remoteVisitPortal);
        categories.add(registration);
        categories.add(virtualVisit);
        categories.add(openKM);
        categories.add(microsoftSharepoint);


        feedbackCategoryRepository.saveAll(categories);
    }
}
