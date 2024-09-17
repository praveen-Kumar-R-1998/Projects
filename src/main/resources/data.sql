CREATE TABLE ToDo (
    ID INT PRIMARY KEY,
    USER_NAME VARCHAR(255),
    DESCRIPTION VARCHAR(500),
    DONE BOOLEAN,
    DATE DATE
);


insert into ToDo(ID,USER_NAME,DESCRIPTION,DONE,DATE)
values(10001,'PRAVEEN','Get AWS Certified',false,CURRENT_DATE());

insert into ToDo(ID,USER_NAME,DESCRIPTION,DONE,DATE)
values(10002,'PRAVEEN','Get Azure Certified',false,CURRENT_DATE());

insert into ToDo(ID,USER_NAME,DESCRIPTION,DONE,DATE)
values(10003,'PRAVEEN','Get Google Cloud Certified',false,CURRENT_DATE());

insert into ToDo(ID,USER_NAME,DESCRIPTION,DONE,DATE)
values(10004,'PRAVEEN','Get Jio Cloud Certified',false,CURRENT_DATE());

