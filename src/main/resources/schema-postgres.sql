DROP TABLE IF EXISTS students;
CREATE TABLE students
(
	id serial PRIMARY KEY,
	name VARCHAR(100),
	age integer
);

DROP TABLE IF EXISTS smart_plugs;
CREATE TABLE smart_plugs
(
	id serial PRIMARY KEY,
	name VARCHAR(100),
	ip_address VARCHAR(16)
);
