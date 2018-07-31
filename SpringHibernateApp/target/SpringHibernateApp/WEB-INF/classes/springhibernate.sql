CREATE DATABASE springhibernate;

USE springhibernate;

CREATE TABLE USERS (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  user_name varchar(50) NOT NULL,
  user_password varchar(50) NOT NULL,
  user_email varchar(100) NOT NULL,
  PRIMARY KEY (user_id)
);

INSERT INTO USERS (user_id, user_name, user_password, user_email) VALUES (1, 'admin', 'admin@1234', 'admin@test.com');
INSERT INTO USERS (user_id, user_name, user_password, user_email) VALUES (2, 'user123', 'user@123', 'user@test.com');
INSERT INTO USERS (user_id, user_name, user_password, user_email) VALUES (3, 'tom789', 'tom@123', 'tom@test.com');
INSERT INTO USERS (user_id, user_name, user_password, user_email) VALUES (4, 'jane456', 'jane@123', 'jane@test.com');
INSERT INTO USERS (user_id, user_name, user_password, user_email) VALUES (5, 'daniel089', 'dan@123', 'daniel@test.com');

SELECT * FROM USERS;