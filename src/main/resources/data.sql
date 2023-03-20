insert into teachers(teacher_id,first_Name,last_Name,dob) values(9001,'Piet', 'Puk', '1995-01-01');
insert into teachers(teacher_id,first_Name,last_Name,dob) values(13951,'Jan', 'Smith', '1996-01-01');
insert into teachers(teacher_id,first_Name,last_Name,dob) values(14001,'Fred', 'Pret', '1996-01-01');
insert into teachers(teacher_id,first_Name,last_Name,dob) values(14051,'Hans', 'Kever', '1996-01-01');
insert into teachers(teacher_id,first_Name,last_Name,dob) values(14101,'Dirk', 'Kurk', '1996-01-01');

insert into students(student_Nr,first_Name,last_Name,phone_Number) values(7801,'Dennis', 'Rijkers', '0628975975');
insert into students(student_Nr,first_Name,last_Name,phone_Number) values(12801,'Max', 'Rijkers', '0628975975');
insert into students(student_Nr,first_Name,last_Name,phone_Number) values(12851,'Koen', 'Rijkers', '0628975975');
insert into students(student_Nr,first_Name,last_Name,phone_Number) values(12901,'Luuk', 'Rijkers', '0628975975');
insert into students(student_Nr,first_Name,last_Name,phone_Number) values(12951,'Nienke', 'Rijkers', '0628975975');

insert into courses(course_Id,title,sp,teacher_id) values(nextval('courses_seq'),'Java', '20','9001');
insert into courses(course_Id,title,sp,teacher_id) values(nextval('courses_seq'),'React', '30','9001');
insert into courses(course_Id,title,sp,teacher_id) values(nextval('courses_seq'),'HTML', '30','9001');
insert into courses(course_Id,title,sp,teacher_id) values(nextval('courses_seq'),'CSS', '30','9001');
insert into courses(course_Id,title,sp,teacher_id) values(nextval('courses_seq'),'JavaScript', '30','9001');
insert into courses(course_Id,title,sp,teacher_id) values(nextval('courses_seq'),'C++', '30','9001');
insert into courses(course_Id,title,sp,teacher_id) values(nextval('courses_seq'),'Python', '30','9001');
insert into courses(course_Id,title,sp,teacher_id) values(nextval('courses_seq'),'C', '30','9001');

insert into teachers_students(id,student_student_nr,teacher_teacher_id) values (nextval('teachers_students_seq'),'7801', '9001');
insert into teachers_students(id,student_student_nr,teacher_teacher_id) values (nextval('teachers_students_seq'),'7801', '13951');
insert into teachers_students(id,student_student_nr,teacher_teacher_id) values (nextval('teachers_students_seq'),'7801', '14101');
