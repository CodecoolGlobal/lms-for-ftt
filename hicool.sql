SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET default_tablespace = '';

SET default_with_oids = false;

SET TIME ZONE 'GMT';

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS attendance CASCADE;
DROP TABLE IF EXISTS assignments CASCADE;
DROP TABLE IF EXISTS answers CASCADE;
DROP TABLE IF EXISTS texts CASCADE;

CREATE TABLE users(
     user_id smallserial,
     user_name varchar(15) NOT NULL,
     email varchar(254) UNIQUE NOT NULL,
     user_role varchar(10) NOT NULL,
     password varchar(25) NOT NULL ,
     PRIMARY KEY(user_id)
);

CREATE TABLE attendance(
    attendance_id smallserial,
    user_id smallint REFERENCES users(user_id) ON DELETE CASCADE,
    date date,
    PRIMARY KEY(attendance_id, user_id)
);

CREATE TABLE assignments(
    assignment_id smallserial,
    title varchar(255) NOT NULL ,
    question text NOT NULL,
    max_score smallint NOT NULL,
    is_published boolean,
    PRIMARY KEY (assignment_id, title)
);

CREATE TABLE answers(
    assignment_id smallint REFERENCES assignments(assignment_id) ON DELETE CASCADE,
    user_id smallint REFERENCES users(user_id) ON DELETE CASCADE,
    answer text,
    score smallint,
    submission_date TIMESTAMP WITH TIME ZONE NOT NULL,
    PRIMARY KEY (assignment_id, user_id)
);

CREATE TABLE texts(
    text_id smallserial,
    title varchar(255),
    text text,
    is_published boolean,
    PRIMARY KEY (text_id, title)
);
