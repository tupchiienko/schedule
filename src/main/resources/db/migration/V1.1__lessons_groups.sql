CREATE TABLE IF NOT EXISTS lessons_groups
(
    lesson_id BIGINT NOT NULL CONSTRAINT lessons_groups_lesson_id_fk REFERENCES lessons(id),
    group_id BIGINT NOT NULL CONSTRAINT lessons_groups_group_id_fk REFERENCES groups(id)
);
