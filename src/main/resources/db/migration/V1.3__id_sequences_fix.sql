SELECT setval('groups_id_seq', max(id)) FROM groups;
SELECT setval('students_id_seq', max(id)) FROM students;
SELECT setval('subjects_id_seq', max(id)) FROM subjects;
SELECT setval('teachers_id_seq', max(id)) FROM teachers;
SELECT setval('classrooms_id_seq', max(id)) FROM classrooms;
SELECT setval('lessons_id_seq', max(id)) FROM lessons;
