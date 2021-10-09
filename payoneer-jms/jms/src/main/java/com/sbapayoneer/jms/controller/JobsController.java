package com.sbapayoneer.jms.controller;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

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
@RequestMapping("/jobs/v1")
public class JobsController {
	
	@Autowired
	private JobsRepository jobsRepository;
	private static final Logger log = LoggerFactory.getLogger(JobsController.class);
	
	@GetMapping("/{id}")
	private Optional<Job> getJobsById(@PathVariable Long id) {
	    return jobsRepository.findById(id);
	}
	
	@PostMapping("/process/{id}")
	private Optional<Job> processJobsById(@PathVariable Long id) {
		Optional<Job> currentJob = jobsRepository.findById(id);
		Job jobToProcess = currentJob != null? currentJob.get():null;
		long delta = jobToProcess.getReqDt().getTime() - new Timestamp(System.currentTimeMillis()).getTime();
		log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		log.info("Job (id="+id+") is scheduled to start in : " + (delta/1000 ) + " seconds");
		log.info(""+jobToProcess);
		log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		new Timer().schedule(
			    new TimerTask() {
			        @Override
			        public void run() {
			        	if(id%3!=0) {
			    			/*Processing Job with Success*/
			    		jobsRepository.updateStatus(id, Constants.STATUS_SUCCESS);
			    		}else {
			    			/*Processing Job with Failure*/
			    			jobsRepository.updateStatus(id, Constants.STATUS_FAILED);
			    		}
			    		
			    		log.info("<<< Finished Processing Job ID: " + id);
			        }
			    }, 
			    delta < 0?0:delta
			);
		
		
		
	    return jobsRepository.findById(id);
	}

}
