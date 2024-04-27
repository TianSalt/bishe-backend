-- Drop tables if they exist

-- Create the "admin" table
DROP TABLE IF EXISTS admin;
CREATE TABLE admin
(
    uid           INT AUTO_INCREMENT PRIMARY KEY,
    username      VARCHAR(30) UNIQUE NOT NULL,
    password_hash VARCHAR(256)       NOT NULL
);

-- Create the "teacher" table
DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher
(
    uid           INT AUTO_INCREMENT PRIMARY KEY,
    employee_id   VARCHAR(255) UNIQUE NOT NULL,
    name          VARCHAR(255)        NOT NULL,
    password_hash VARCHAR(256)        NOT NULL
) DEFAULT CHARSET = utf8;

-- Create the "student" table
DROP TABLE IF EXISTS student;
CREATE TABLE student
(
    uid          INT AUTO_INCREMENT PRIMARY KEY,
    student_id   VARCHAR(255) UNIQUE NOT NULL,
    name         VARCHAR(255)        NOT NULL,
    major        VARCHAR(255),
    school_class VARCHAR(255)
) DEFAULT CHARSET = utf8;

-- Create the "exam" table
DROP TABLE IF EXISTS exam;
CREATE TABLE exam
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    creator       INT,
    is_published  BOOLEAN DEFAULT FALSE,
    exam_name     VARCHAR(255),
    start_time    TIMESTAMP,
    end_time      TIMESTAMP,
    is_encrypted  BOOLEAN,
    password_hash VARCHAR(256),
    content       TEXT,
    introduction  TEXT,
    comment       TEXT,
    FOREIGN KEY (creator) REFERENCES teacher (uid)
) DEFAULT CHARSET = utf8;

-- Create the "student_exam" table
DROP TABLE IF EXISTS student_exam;
CREATE TABLE student_exam
(
    student_uid INT,
    exam_id     INT,
    presence    BOOLEAN DEFAULT TRUE,
    answer      TEXT, -- Answers of every question
    score       TEXT, -- Scores of every question
    FOREIGN KEY (student_uid) REFERENCES student (uid),
    FOREIGN KEY (exam_id) REFERENCES exam (id)
);

-- Create the "question" table
DROP TABLE IF EXISTS question;
CREATE TABLE question
(
    question_id    INT AUTO_INCREMENT PRIMARY KEY,
    question_type  INT,
    content        TEXT,
    correct_answer TEXT
) DEFAULT CHARSET = utf8;

-- Add indexes to the student_id and employee_id columns
ALTER TABLE student
    ADD INDEX idx_student_id (student_id);
ALTER TABLE teacher
    ADD INDEX idx_employee_id (employee_id);
