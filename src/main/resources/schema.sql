-- CREATE TABLE pet (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     petName VARCHAR(255),
--     species VARCHAR(255),
--     age INT,
--     details VARCHAR(255),
--     image BLOB,
--     available BOOLEAN,
--     breed VARCHAR(255),
--     color VARCHAR(255),
--     gender VARCHAR(10),
--     size VARCHAR(20),
--     weight DOUBLE,
--     ownerName VARCHAR(255),
--     ownerContact VARCHAR(20),
--     vaccinated BOOLEAN,
--     medicalHistory VARCHAR(1000),
--     dateAdded TIMESTAMP
-- );


CREATE TABLE Donor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    donorName VARCHAR(255),
    donateAmount DOUBLE,
    donorEmail VARCHAR(255),
    donorNumber VARCHAR(20),
    address VARCHAR(255)
);


CREATE TABLE event (
    id INT PRIMARY KEY AUTO_INCREMENT,
    eventName VARCHAR(255) NOT NULL,
    eventDate Date NOT NULL,
    eventTime TIME NOT NULL,
    location VARCHAR(255) NOT NULL,
    participantName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL
);




create table SEC_USER
(
  userId           BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userName         VARCHAR(36) NOT NULL UNIQUE,
  encryptedPassword VARCHAR(128) NOT NULL,
  email VARCHAR(128) NOT NULL,
  ENABLED           BIT NOT NULL 
) ;


create table SEC_ROLE
(
  roleId   BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  roleName VARCHAR(30) NOT NULL UNIQUE
) ;


create table USER_ROLE
(
  ID      BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userId BIGINT NOT NULL,
  roleId BIGINT NOT NULL
);

alter table USER_ROLE
  add constraint USER_ROLE_UK unique (userId, roleId);

alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (userId)
  references SEC_USER (userId);
 
alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (roleId)
  references SEC_ROLE (roleId);








