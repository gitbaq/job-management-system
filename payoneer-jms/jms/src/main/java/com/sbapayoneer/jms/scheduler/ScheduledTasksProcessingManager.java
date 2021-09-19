package com.sbapayoneer.jms.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.sbapayoneer.jms.config.Constants;
import com.sbapayoneer.jms.model.Job;
import com.sbapayoneer.jms.repositories.JobsRepository;

import reactor.core.publisher.Mono;




@Component
public class ScheduledTasksProcessingManager {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasksProcessingManager.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	@Autowired
	  private JobsRepository repository;

	@Scheduled(fixedRate = Constants.QUEUE_TIMER)
	public void reportCurrentTime() {
		List<Job> jobsList = repository.findByStatus(Constants.STATUS_QUEUED);
	if(jobsList.iterator().hasNext()) 
	{
		WebClient client = WebClient.create("http://localhost:8080");
		for (Job job : jobsList) {
			log.info("<"+ dateFormat.format(new Date())+"> Running job: "+ job.getJobName());
			repository.updateStatus(job.getId(), Constants.STATUS_RUNNING);
			Mono<Job> processedJob = client.post()
					  .uri("/jobs/process/{id}", job.getId())
					  .retrieve()
					  .bodyToMono(Job.class);
			
			

			processedJob.subscribe(System.out::println);
		    }
		
		} 
	else {
		log.info("Nothing found");
	}
	}
}