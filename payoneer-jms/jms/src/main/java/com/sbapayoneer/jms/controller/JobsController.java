package com.sbapayoneer.jms.controller;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbapayoneer.jms.config.Constants;
import com.sbapayoneer.jms.model.Job;
import com.sbapayoneer.jms.repositories.JobsRepository;

@RestController
@RequestMapping("/jobs")
public class JobsController {
	
	@Autowired
	private JobsRepository jobsRepository;
	private static final Logger log = LoggerFactory.getLogger(JobsController.class);
	
	@GetMapping("/{id}")
	private Optional<Job> getJobsById(@PathVariable int id) {
	    return jobsRepository.findById(id);
	}
	
	@PostMapping("/process/{id}")
	private Optional<Job> processJobsById(@PathVariable int id) {
		
		if(id%3!=0) {
		jobsRepository.updateStatus(id, Constants.STATUS_SUCCESS);
		}else {
			jobsRepository.updateStatus(id, Constants.STATUS_FAILED);
		}
		
		log.info("<<< Finished Processing Job ID: " + id);
	    return jobsRepository.findById(id);
	}

}
