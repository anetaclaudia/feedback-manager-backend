package com.feedback.backend;

import com.feedback.backend.controller.FeedbackController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private FeedbackController controller;

	@Test
	void contextLoads() {
		assert controller != null;
	}

}
