CREATE TABLE ExProject.Users (
	userId MEDIUMINT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    password VARCHAR(50) NOT NULL,
    lastLoginDateTime DATETIME,
    confirmed TINYINT(1) NOT NULL,
	picture BLOB,
    token VARCHAR(255),
    archived TINYINT(1) NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (userId)
);

CREATE TABLE ExProject.UserTypes (
	userTypeId MEDIUMINT NOT NULL AUTO_INCREMENT,
    userId MEDIUMINT NOT NULL,
    projectId MEDIUMINT,
    userType VARCHAR(10) NOT NULL,
    CONSTRAINT userTyeps_pk PRIMARY KEY (userTypeId)
);

CREATE TABLE ExProject.Projects (
    projectId MEDIUMINT NOT NULL AUTO_INCREMENT,
    projectName VARCHAR(60) NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    completed TINYINT(1) NOT NULL,
    picture TEXT(65535),
    CONSTRAINT projects_pk PRIMARY KEY (projectId)
);

CREATE TABLE ExProject.ProjectAssignments (
    projectAssignmentsId MEDIUMINT NOT NULL AUTO_INCREMENT,
    projectId MEDIUMINT NOT NULL,
    userId MEDIUMINT NOT NULL,
    CONSTRAINT pa_pk PRIMARY KEY (projectAssignmentsId)
);

CREATE TABLE ExProject.Tasks (
    taskId MEDIUMINT NOT NULL AUTO_INCREMENT,
    taskName VARCHAR(60) NOT NULL,
    startDate DATE NOT NULL,
    enddate DATE NOT NULL,
    completed TINYINT(1) NOT NULL,
    approved TINYINT(1) NOT NULL,
    CONSTRAINT tasks_pk PRIMARY KEY (taskId)
);

CREATE TABLE ExProject.TaskAssignments (
    taskAssignmentsId MEDIUMINT NOT NULL AUTO_INCREMENT,
    taskId MEDIUMINT NOT NULL,
    projectId MEDIUMINT NOT NULL,
    userId MEDIUMINT,
    CONSTRAINT task_assignment_pk PRIMARY KEY (taskAssignmentsId)
);

CREATE TABLE ExProject.Reviews (
    reviewId MEDIUMINT NOT NULL,
    title VARCHAR(60) NOT NULL,
    description VARCHAR(500) NOT NULL,
    reviewDate DATE NOT NULL,
    CONSTRAINT reviews_pk PRIMARY KEY (reviewId)
);

CREATE TABLE ExProject.ReviewAssignments (
    reviewAssignmentsId MEDIUMINT NOT NULL AUTO_INCREMENT,
    reviewId MEDIUMINT NOT NULL,
    userId MEDIUMINT NOT NULL,
    reviewerId MEDIUMINT NOT NULL,
    projectId MEDIUMINT NOT NULL,
    CONSTRAINT reviewAssignments_pk PRIMARY KEY (reviewAssignmentsId)
);