CREATE TABLE IF NOT EXISTS groups
(
    id bigserial primary key,
    code varchar(5) not null unique
);

CREATE TABLE IF NOT EXISTS students
(
    id bigserial primary key,
    first_name varchar(32) not null,
    last_name varchar(32) not null,
    group_id bigint not null CONSTRAINT students_group_id_fk REFERENCES groups(id)
);

CREATE TABLE IF NOT EXISTS subjects
(
    id bigserial primary key,
    name varchar(128) not null
);

CREATE TABLE IF NOT EXISTS teachers
(
    id bigserial primary key,
    first_name varchar(32) not null,
    last_name varchar(32) not null
);

CREATE TABLE IF NOT EXISTS classrooms
(
    id bigserial primary key,
    pavilion_number int not null,
    room_number int not null
);

CREATE TABLE IF NOT EXISTS lessons
(
    id bigserial primary key,
    subject_id bigint not null CONSTRAINT lessons_subject_id_fk REFERENCES subjects(id),
    teacher_id bigint not null CONSTRAINT lessons_teacher_id_fk REFERENCES teachers(id),
    classroom_id bigint not null CONSTRAINT lessons_classroom_id_fk REFERENCES classrooms(id),
    day_of_week smallint not null,
    time time not null
);
