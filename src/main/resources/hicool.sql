--PostgreSQL 9.6
--'\\' is a delimiter

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
                           PRIMARY KEY(attendance_id)
);

CREATE TABLE assignments(
                            assignment_id smallserial,
                            title varchar(255) NOT NULL ,
                            question text NOT NULL,
                            max_score smallint NOT NULL,
                            is_published boolean,
                            PRIMARY KEY (assignment_id)
);

CREATE TABLE answers(
                        assignment_id smallserial REFERENCES assignments(assignment_id) ON DELETE CASCADE,
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
                      PRIMARY KEY (text_id)
);

INSERT INTO users (user_name, email, user_role, password) VALUES ('Rory', 'rory@gmail.com', 'mentor', 'hicool?1');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Charlie', 'charlie@gmail.com', 'student', 'hicool?2');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Jules', 'jules@gmail.com', 'student', 'hicool?3');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Jade', 'jade@gmail.com', 'student', 'hicool?4');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Jess', 'jess@gmail.com', 'student', 'hicool?5');
INSERT INTO users (user_name, email, user_role, password) VALUES ('MacAndCheese', 'mac@gmail.com', 'student', 'hicool?6');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Dean', 'dean@gmail.com', 'student', 'hicool?7');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Julie', 'julie@gmail.com', 'student', 'hicool?8');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Attila', 'attila@gmail.com', 'mentor', 'hicool?9');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Kate', 'kate@gmail.com', 'student', 'hicool?10');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Bálint', 'balint@gmail.com', 'student', 'hicool?11');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Rupert', 'rupert@gmail.com', 'student', 'hicool?12');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Roger', 'roger@gmail.com', 'student', 'hicool?13');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Lorelei', 'lorelei@gmail.com', 'student', 'hicool?14');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Marie-Claire', 'marieclaire@gmail.com', 'student', 'hicool?15');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Brandon', 'brandon@gmail.com', 'student', 'hicool?16');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Tamy', 'tamy@gmail.com', 'mentor', 'hicool?17');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Andi', 'andi@gmail.com', 'student', 'hicool?18');
INSERT INTO users (user_name, email, user_role, password) VALUES ('Berta', 'berta@gmail.com', 'mentor', 'hicool?19');

INSERT INTO attendance (user_id, date) VALUES (1, '2019-06-12');
INSERT INTO attendance (user_id, date) VALUES (2, '2019-06-12');
INSERT INTO attendance (user_id, date) VALUES (5, '2019-06-12');
INSERT INTO attendance (user_id, date) VALUES (3, '2019-06-12');
INSERT INTO attendance (user_id, date) VALUES (2, '2019-06-13');
INSERT INTO attendance (user_id, date) VALUES (1, '2019-06-13');
INSERT INTO attendance (user_id, date) VALUES (2, '2019-06-17');
INSERT INTO attendance (user_id, date) VALUES (1, '2019-06-17');
INSERT INTO attendance (user_id, date) VALUES (10, '2019-06-17');
INSERT INTO attendance (user_id, date) VALUES (17, '2019-06-18');
INSERT INTO attendance (user_id, date) VALUES (15, '2019-06-18');
INSERT INTO attendance (user_id, date) VALUES (16, '2019-06-18');

INSERT INTO assignments (title, question, max_score, is_published) VALUES ('What is the output1?', 'Kecske????', 10, false);
INSERT INTO assignments (title, question, max_score, is_published) VALUES ('Does this method work?', 'The following method purports to determine whether its sole argument is an odd number. Does the method work? <br><br>public static boolean isOdd(int i){<br>return i % 2 == 1;}', 3, true);
INSERT INTO assignments (title, question, max_score, is_published) VALUES ('What is the output?', 'Consider the following word problem:<br> Tom goes to the auto parts store to buy a spark plug that costs $1.10, but all he has in his wallet are two-dollar bills. How much change should he get if he pays for the spark plug with a two-dollar bill? <br><br>Here is a program that attempts to solve the word problem. What does it print? <br><br>public class Change {<br>public static void main(String args[]) {<br>System.out.println(2.00 - 1.10);}<br>}', 10, true);
INSERT INTO assignments (title, question, max_score, is_published) VALUES ('It is elementary', 'This program involves only addition. What does it print? <br><br>public class Elementary {<br>public static void main(String[] args) {<br>System.out.println(12345 + 5432l);}<br>}', 10, false);
INSERT INTO assignments (title, question, max_score, is_published) VALUES ('Multicast', 'Casts are used to convert a value from one type to another. This program uses three casts in succession. What does it print?<br><br>public class Multicast {<br>public static void main(String[] args) {<br>System.out.println((int) (char) (byte) -1);}<br>}', 10, true);
INSERT INTO assignments (title, question, max_score, is_published) VALUES ('Write a code!', 'Now it is your turn to write some code. On the bright side, you have to write only two lines for this puzzle and two lines for the next. How hard could that be? Provide declarations for the variables x and i such that this is a legal statement:<br>x += i;<br><br>but this is not:<br>x = x + i;', 10, true);


INSERT INTO texts (title, text, is_published) VALUES ('Sessions','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('Filters','Filters allow to pass or block a requests based on some criteria. They decide which request to block by inspecting the "request" object. Requests containing a JSESSIONID which has an associated attribute, flag, object, etc. which signifies that the user (which to the JSESSIONID belongs to) has already logged in are allowed to pass, other requests are blocked (e.g. redirected to the login page).',true);
INSERT INTO texts(title, text, is_published) VALUES ('Handling XML with Java?','When you were dealing with CSV you had to write custom code to read and write CSV files. This is what we call serialization (writing objects to a file in a certain format) and deserialization (reading a file in a certain format into objects). You have to do something similar when dealing with XML, but it is a little more complex, and you have to get a grasp of the DOM concept.',false);
INSERT INTO texts(title, text, is_published) VALUES ('Yet another language to master: Java','Java programming language was originally developed' ||
                                                                                            'by Sun Microsystems which was initiated by James Gosling and released in 1995 as core component of Sun Microsystems'' Java platform (Java 1.0 [J2SE]). The latest stable release of the Java Standard Edition is Java SE 9. With the advancement of Java and its widespread popularity, multiple configurations were built to suit various types of platforms. For example: J2EE for Enterprise Applications, J2ME for Mobile Applications. <br> <br>' ||
                                                                                            'The new J2 versions were renamed as Java SE, Java EE, and Java ME respectively. Java is guaranteed to be Write Once, Run Anywhere. <br><ul><li>Object Oriented − In Java,' ||
                                                                                            'everything is an Object. Java can be easily extended since it is based on the Object model.</li><li>Simple − Java is designed to be easy to learn. If you understand the basic concept of OOP Java, it would be easy to master.</li><li>Secure − With Java''s secure feature it enables to develop virus-free, tamper-free systems. Authentication techniques are based on public-key encryption.</li></ul>',true);
INSERT INTO texts(title, text, is_published) VALUES ('Interpreted vs. compiled','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('for vs foreach','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',false);
INSERT INTO texts(title, text, is_published) VALUES ('Method signature','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('Compile-time vs runtime','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('Static vs dynamic typing','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('The new, the instanceof and the cast','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',false);
INSERT INTO texts(title, text, is_published) VALUES ('The Waterfall project management method','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('How to compile and run Java','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('Enums','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('Arrays','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',false);
INSERT INTO texts(title, text, is_published) VALUES ('Javadoc','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('Exception handling','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('toString()?','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('Modifiers - pppp, static, final','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',false);
INSERT INTO texts(title, text, is_published) VALUES ('Choosing the Right Method Signature','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);
INSERT INTO texts(title, text, is_published) VALUES ('Getters-Setters','Session is a generic term in the context of computers, programming. Here is a very broad description of it. You have seen and used session during the Green Commitment project. Clients connected the server, sent some information over their socket connection, then terminated the connection. This was basically a session between the client and the server. Right now what we are interested in are HTTP sessions.',true);

