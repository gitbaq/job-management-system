

INSERT INTO jms_jobs (job_name, job_desc, add_dt,add_cd, req_dt, status) VALUES
  ('DWH Loader','Load Data in DWH',CURRENT_TIMESTAMP(),CURRENT_USER(),DATEADD(SS, 60, CURRENT_TIMESTAMP()) ,'Q'),
  ('Emailer','Send Emails',CURRENT_TIMESTAMP(),CURRENT_USER(),DATEADD(SS, 120, CURRENT_TIMESTAMP()) ,'Q'),
  ('Another','That is one more task!!',CURRENT_TIMESTAMP(),'SOME1',DATEADD(SS, 180, CURRENT_TIMESTAMP()) ,'Q');