/**
CREATE TABLE To_Do (
    ID INT PRIMARY KEY,
    USER_NAME VARCHAR(255),
    DESCRIPTION VARCHAR(500),
    DONE BOOLEAN,
    DATE DATE
);


insert into To_Do(ID,USER_NAME,DESCRIPTION,DONE,DATE)
values(10001,'praveen','Get AWS Certified',false,CURRENT_DATE());

insert into To_Do(ID,USER_NAME,DESCRIPTION,DONE,DATE)
values(10002,'praveen','Get Azure Certified',false,CURRENT_DATE());

insert into To_Do(ID,USER_NAME,DESCRIPTION,DONE,DATE)
values(10003,'praveen','Get Google Cloud Certified',false,CURRENT_DATE());

insert into To_Do(ID,USER_NAME,DESCRIPTION,DONE,DATE)
values(10004,'praveen','Get Jio Cloud Certified',false,CURRENT_DATE());*/

-- Create the table only if it doesn't already exist
-- Create the table if it doesn't exist

CREATE TABLE IF NOT EXISTS To_Do (
    ID INT PRIMARY KEY,
    USER_NAME VARCHAR(255),
    DESCRIPTION VARCHAR(500),
    DONE BOOLEAN,
    DATE DATE
);

-- Insert data, checking for existence based on ID
MERGE INTO To_Do (ID, USER_NAME, DESCRIPTION, DONE, DATE) 
KEY(ID) 
VALUES(10001, 'praveen', 'Get AWS Certified', FALSE, CURRENT_DATE());

MERGE INTO To_Do (ID, USER_NAME, DESCRIPTION, DONE, DATE) 
KEY(ID) 
VALUES(10002, 'praveen', 'Get Azure Certified', FALSE, CURRENT_DATE());

MERGE INTO To_Do (ID, USER_NAME, DESCRIPTION, DONE, DATE) 
KEY(ID) 
VALUES(10003, 'praveen', 'Get Google Cloud Certified', FALSE, CURRENT_DATE());

MERGE INTO To_Do (ID, USER_NAME, DESCRIPTION, DONE, DATE) 
KEY(ID) 
VALUES(10004, 'praveen', 'Get Jio Cloud Certified', FALSE, CURRENT_DATE());




