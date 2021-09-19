package com.sbapayoneer.jms.scheduler;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sbapayoneer.jms.config.Constants;
import com.sbapayoneer.jms.model.Job;
import com.sbapayoneer.jms.repositories.JobsRepository;

@Component
public class TasksScheduler {
	@Value( "${spring.datasource.username}" )
	private String loggedInUSer;
	
	private static final Logger log = LoggerFactory.getLogger(TasksScheduler.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMDDYYYY HH:mm:ss");
	
	@Autowired
	  private JobsRepository repository;
	
	@Scheduled(fixedRate = Constants.QUEUE_ADD_TIMER)
	public void reportCurrentTime() {
		Job job = new Job();
		job.setJobName("Job@" +dateFormat.format(new Date(new java.util.Date().getTime())));
		job.setJobDesc(job.getJobName());
			job.setAdd_dt(new Timestamp(System.currentTimeMillis()));
			job.setReqDt(new Timestamp(System.currentTimeMillis()));
			job.setAddCd(loggedInUSer);
			
		
		job.setStatus(Constants.STATUS_QUEUED);
		repository.save(job);
		log.info("*** New Job Added " + job);
	}

}
