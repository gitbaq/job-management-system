package com.sbapayoneer.jms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sbapayoneer.jms.model.Job;


public interface JobsRepository extends CrudRepository<Job, Object>{
	public List<Job> findById(String id);
	public List<Job> findByStatus(String status);
	
	@Modifying
	@Transactional
	@Query("update Job u set u.status = :status where u.id = :id")
	void updateStatus(@Param(value = "id") int id, @Param(value = "status") String status);
 }
