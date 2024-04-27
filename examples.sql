-- Insert sample data for teacher table
INSERT INTO teacher (employee_id, name, password_hash)
VALUES ('01', 'Teacher 1', '147f8f82daaebdddd17283a689df793c'), -- YiszQDAWrJ
       ('02', 'Teacher 2', 'fd282f7f70b7df92a9f5cddc4a1e903e'), -- DJfNJKokwW
       ('03', 'Teacher 3', '7ef6baa722603b2d5cf9d02c8f93d54b'), -- hGzqXjZpKs
       ('04', 'Teacher 4', 'fadca23c9b3a245f8210ae22decc702d'), -- LmRvYsXtZu
       ('05', 'Teacher 5', '5f5d66ca9a1c61d172945d28140ee607'); -- FbWkQpTjHn

-- Insert sample data for student table
INSERT INTO student (student_id, name, major, school_class)
VALUES ('01', 'Student 1', 'Math', 'Class 1'),
       ('02', 'Student 2', 'Science', 'Class 2'),
       ('03', 'Student 3', 'History', 'Class 3'),
       ('04', 'Student 4', 'English', 'Class 4'),
       ('05', 'Student 5', 'Math', 'Class 5'),
       ('06', 'Student 6', 'Science', 'Class 6'),
       ('07', 'Student 7', 'History', 'Class 7'),
       ('08', 'Student 8', 'Science', 'Class 8'),
       ('09', 'Student 9', 'Math', 'Class 9'),
       ('010', 'Student 10', 'History', 'Class 10');
