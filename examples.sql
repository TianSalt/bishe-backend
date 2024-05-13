-- Insert sample data for teacher table
INSERT INTO exam_system.teacher (uid, employee_id, name, password_hash) VALUES (35, '01', '张美', '202cb962ac59075b964b07152d234b70');
INSERT INTO exam_system.teacher (uid, employee_id, name, password_hash) VALUES (36, '02', '王明', '202cb962ac59075b964b07152d234b70');
INSERT INTO exam_system.teacher (uid, employee_id, name, password_hash) VALUES (39, '04', '刘红', '202cb962ac59075b964b07152d234b70');
INSERT INTO exam_system.teacher (uid, employee_id, name, password_hash) VALUES (56, '05', '刘明', '202cb962ac59075b964b07152d234b70');
INSERT INTO exam_system.teacher (uid, employee_id, name, password_hash) VALUES (57, '03', '李刚', '202cb962ac59075b964b07152d234b70');
INSERT INTO exam_system.teacher (uid, employee_id, name, password_hash) VALUES (59, '06', '酷儿', '76d80224611fc919a5d54f0ff9fba446');
INSERT INTO exam_system.teacher (uid, employee_id, name, password_hash) VALUES (61, '07', '海盐', 'c92cad3403072a8ede9ad747629de116');
INSERT INTO exam_system.teacher (uid, employee_id, name, password_hash) VALUES (63, '09', '李强', '202cb962ac59075b964b07152d234b70');
INSERT INTO exam_system.teacher (uid, employee_id, name, password_hash) VALUES (64, '08', '岚', '202cb962ac59075b964b07152d234b70');
INSERT INTO exam_system.teacher (uid, employee_id, name, password_hash) VALUES (74, '10', '啊哈', '1d5ffd3c4e0dde41443505d77bf49d45');


-- Insert sample data for student table
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (1, '202401', '李华', '计算机科学', '计科01');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (2, '202402', '王明', '计算机科学', '计科01');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (3, '202403', '张伟', '计算机科学', '计科01');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (4, '202404', '刘洋', '计算机科学', '计科01');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (5, '202405', '陈娟', '计算机科学', '计科02');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (6, '202406', '杨明', '计算机科学', '计科02');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (7, '202407', '王芳', '计算机科学', '计科02');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (8, '202408', '张军', '软件工程', '软件01');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (9, '202409', '刘磊', '软件工程', '软件01');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (10, '202410', '王伟', '软件工程', '软件01');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (11, '202411', '李明', '软件工程', '软件01');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (12, '202412', '张丽', '软件工程', '软件02');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (14, '202414', '王静', '软件工程', '软件02');
INSERT INTO exam_system.student (uid, student_id, name, major, school_class) VALUES (15, '202415', '李军', '软件工程', '软件02');

INSERT INTO exam_system.question (question_id, creator, question_type, content, correct_answer) VALUES (1, 36, 1, '语言学的三大发源地是
#中国
#印度
#希腊－罗马
#苏美尔', 'ABC');
INSERT INTO exam_system.question (question_id, creator, question_type, content, correct_answer) VALUES (2, 36, 2, '现代语言学的标志性著作是瑞士语言学家 #_ 的 《普通语言学教程》。', '索绪尔');
INSERT INTO exam_system.question (question_id, creator, question_type, content, correct_answer) VALUES (27, 36, 2, '符号包括形式和 #_ 两个方面，二者不可分离', '意义');
INSERT INTO exam_system.question (question_id, creator, question_type, content, correct_answer) VALUES (28, 36, 0, '普通话「扑」的声母，用国际音标表示是
#pʰ
#p
#bʰ
#b', 'A');
