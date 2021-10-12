package com.sbapayoneer.jms.model;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "JMS_JOBS")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String jobName;
	private String jobDesc;
	private Timestamp addDt;
	private String addCd;
	private Timestamp reqDt;
	String status;
	
	@Builder
    public Job(Long id, String jobName, String jobDesc,Timestamp addDt, String addCd, Timestamp reqDt, 
    		String status) {
        this.id = id;
        this.jobName = jobName;
        this.jobDesc = jobDesc;
        this.addDt = addDt;
        this.addCd = addCd;
        this.reqDt = reqDt;
        this.status = status;
    }


	public Job() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the jobDesc
	 */
	public String getJobDesc() {
		return jobDesc;
	}

	/**
	 * @param jobDesc the jobDesc to set
	 */
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	/**
	 * @return the addDt
	 */
	public Timestamp getAddDt() {
		return addDt;
	}

	/**
	 * @param addDt the addDt to set
	 */
	public void setAddDt(Timestamp addDt) {
		this.addDt = addDt;
	}

	/**
	 * @return the addCd
	 */
	public String getAddCd() {
		return addCd;
	}

	/**
	 * @param addCd the addCd to set
	 */
	public void setAddCd(String addCd) {
		this.addCd = addCd;
	}

	/**
	 * @return the reqDt
	 */
	public Timestamp getReqDt() {
		return reqDt;
	}

	/**
	 * @param reqDt the reqDt to set
	 */
	public void setReqDt(Timestamp reqDt) {
		this.reqDt = reqDt;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Job [" + (id != null ? "id=" + id + ", " : "") + (jobName != null ? "jobName=" + jobName + ", " : "")
				+ (jobDesc != null ? "jobDesc=" + jobDesc + ", " : "") + (addDt != null ? "addDt=" + addDt + ", " : "")
				+ (addCd != null ? "addCd=" + addCd + ", " : "") + (reqDt != null ? "reqDt=" + reqDt + ", " : "")
				+ (status != null ? "status=" + status : "") + "]";
	}
	
	
	
	
	
	
	
	

}
