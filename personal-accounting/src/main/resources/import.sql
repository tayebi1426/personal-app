INSERT INTO PUBLIC.USER (USERNAME,PASSWORD, EXPIRED, LOCKED,  CREATED_BY_ID, LAST_MODIFIED_BY_ID, CREATED_DATE, LAST_MODIFIED_DATE) VALUES ('A$dmIn','$2a$10$NgFTcxZUn9h8oQZUtOpUYetQlEUAw0TrjVbEcaOeftrCTtr.e58E6',0,0,1,1,current_date,current_date);
INSERT INTO PUBLIC.ACCOUNT (NAME, BALANCE, INITIAL_BALANCE, CREATED_BY_ID, LAST_MODIFIED_BY_ID, CREATED_DATE, LAST_MODIFIED_DATE) VALUES ('my-bank-account', 1000, 1000,  1, 1,current_date,current_date);
INSERT INTO PUBLIC.TRANSACTION_TYPE (ID,CODE, TITLE) VALUES (1,'INCOME','INCOME');
INSERT INTO PUBLIC.TRANSACTION_TYPE (ID,CODE, TITLE) VALUES (2,'EXPENSE','EXPENSE');
