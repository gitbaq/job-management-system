DROP TABLE IF EXISTS jms_jobs;

CREATE TABLE jms_jobs (
  id INT AUTO_INCREMENT  PRIMARY KEY comment 'Auto Generated Primary Key', 
  job_name VARCHAR(250)  comment 'Job Name',
  job_desc VARCHAR(250)  comment 'Job Description',
  add_dt TIMESTAMP  comment 'Date/Time this job was added to the system',
  add_cd VARCHAR(250)  comment 'USER Id that added this job',
  req_dt TIMESTAMP  comment 'Date/Time this job should run on',
  status VARCHAR(1)
 
);