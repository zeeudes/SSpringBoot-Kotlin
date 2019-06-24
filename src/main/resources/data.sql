INSERT INTO user (id, birth_date, name, is_deleted) VALUES (NEXTVAL('USER_SEQUENCE'), sysdate(), 'AB', false);
INSERT INTO user (id, birth_date, name, is_deleted) VALUES (NEXTVAL('USER_SEQUENCE'), sysdate(), 'Jill', false);
INSERT INTO user (id, birth_date, name, is_deleted) VALUES (NEXTVAL('USER_SEQUENCE'), sysdate(), 'Jam', false);

INSERT INTO post (id, description, user_id) VALUES (NEXTVAL('POST_SEQUENCE'), 'My First Post', 1);
INSERT INTO post (id, description, user_id) VALUES (NEXTVAL('POST_SEQUENCE'), 'My Second Post', 1);

