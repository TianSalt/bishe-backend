DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS student_exam;
DROP TABLE IF EXISTS exam_question;
DROP TABLE IF EXISTS student_exam_question;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS exam;
DROP TABLE IF EXISTS teacher;

CREATE TABLE admin
(
    uid           INT AUTO_INCREMENT PRIMARY KEY,
    username      VARCHAR(30) UNIQUE NOT NULL,
    password_hash VARCHAR(255)       NOT NULL
);

CREATE TABLE student
(
    uid          INT AUTO_INCREMENT PRIMARY KEY,
    student_id   VARCHAR(255) UNIQUE NOT NULL,
    name         VARCHAR(255)        NOT NULL,
    major        VARCHAR(255),
    school_class VARCHAR(255)
) DEFAULT CHARSET = utf8;

CREATE TABLE teacher
(
    uid           INT AUTO_INCREMENT PRIMARY KEY,
    employee_id   VARCHAR(255) UNIQUE NOT NULL,
    name          VARCHAR(255)        NOT NULL,
    password_hash VARCHAR(255)        NOT NULL
) DEFAULT CHARSET = utf8;

CREATE TABLE exam
(
    exam_id      INT AUTO_INCREMENT PRIMARY KEY,
    creator      INT NOT NULL,
    is_published BOOLEAN DEFAULT FALSE,
    title        VARCHAR(255),
    start_time   DATETIME,
    end_time     DATETIME,
    introduction TEXT,
    FOREIGN KEY (creator) REFERENCES teacher (uid) ON DELETE CASCADE
) DEFAULT CHARSET = utf8;

CREATE TABLE question
(
    question_id    INT AUTO_INCREMENT PRIMARY KEY,
    creator        INT,
    question_type  INT,
    content        TEXT,
    correct_answer TEXT,
    FOREIGN KEY (creator) REFERENCES teacher (uid) ON DELETE CASCADE
) DEFAULT CHARSET = utf8;

CREATE TABLE student_exam
(
    student_uid INT,
    exam_id     INT,
    presence    BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (student_uid) REFERENCES student (uid) ON DELETE CASCADE,
    FOREIGN KEY (exam_id) REFERENCES exam (exam_id) ON DELETE CASCADE,
    PRIMARY KEY (student_uid, exam_id)
);

CREATE TABLE exam_question
(
    exam_id        INT,
    question_index INT,
    question_id    INT,
    score          DECIMAL(10, 1),
    FOREIGN KEY (exam_id) REFERENCES exam (exam_id) ON DELETE CASCADE,
    FOREIGN KEY (question_id) REFERENCES question (question_id) ON DELETE CASCADE,
    PRIMARY KEY (exam_id, question_index)
);

CREATE TABLE student_exam_question
(
    student_uid    INT,
    exam_id        INT,
    question_index INT,
    answer         TEXT,
    score          DECIMAL(10, 1),
    FOREIGN KEY (student_uid) REFERENCES student (uid) ON DELETE CASCADE,
    FOREIGN KEY (exam_id, question_index) REFERENCES exam_question (exam_id, question_index) ON DELETE CASCADE,
    PRIMARY KEY (student_uid, exam_id, question_index)
) DEFAULT CHARSET = utf8;
