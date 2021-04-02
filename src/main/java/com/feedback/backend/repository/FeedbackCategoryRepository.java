package com.feedback.backend.repository;

import com.feedback.backend.model.FeedbackCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackCategoryRepository extends JpaRepository<FeedbackCategory, Long> {
}
