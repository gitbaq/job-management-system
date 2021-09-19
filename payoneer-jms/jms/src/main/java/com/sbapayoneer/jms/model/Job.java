package com.sbapayoneer.jms.model;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JMS_JOBS")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String jobName;
	String jobDesc;
	Timestamp add_dt;
	
	
	String addCd;
	Timestamp reqDt;
	String status;
	public Job() {}
	
	public Job(int id) {
		this.id = id;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the add_dt
	 */
	public Timestamp getAdd_dt() {
		return add_dt;
	}
	/**
	 * @param date the add_dt to set
	 */
	public void setAdd_dt(Timestamp date) {
		this.add_dt = date;
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
		return "Job [id=" + id + ", jobName=" + jobName + ", jobDesc=" + jobDesc + ", add_dt=" + add_dt + ", addCd="
				+ addCd + ", reqDt=" + reqDt + ", status=" + status + "]";
	}
	
	

}
