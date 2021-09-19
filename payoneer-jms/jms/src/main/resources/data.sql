

INSERT INTO jms_jobs (job_name, job_desc, add_dt,add_cd, req_dt, status) VALUES
  ('DWH Loader','Load Data in DWH',CURRENT_TIMESTAMP(),CURRENT_USER(),CURRENT_TIMESTAMP(),'Q'),
  ('Emailer','Send Emails',CURRENT_TIMESTAMP(),CURRENT_USER(),null,'Q'),
  ('Another','That is one more task!!',CURRENT_TIMESTAMP(),'SOME1',null,'Q');