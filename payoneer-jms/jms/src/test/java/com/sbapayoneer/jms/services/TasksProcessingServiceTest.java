/**
 * 
 */
package com.sbapayoneer.jms.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sbapayoneer.jms.model.Job;
import com.sbapayoneer.jms.repositories.JobsRepository;

/**
 * @author syedbaqirali
 *
 */
@DataJpaTest 
class TasksProcessingServiceTest {
	
	@Autowired
	  private JobsRepository repository;

	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		Job newJob = new Job();
		newJob.setId(1L);
		repository.save(newJob);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sbapayoneer.jms.services.TasksProcessingService#processJob()}.
	 */
	@Test
	void testProcessJob() {
		//fail("Not yet implemented");
		Job testJob = repository.findById(1L).get();
		assertNotNull(testJob);
		//fail("Does Not work");
	}

}
