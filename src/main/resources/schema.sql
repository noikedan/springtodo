CREATE SEQUENCE tasks_seq;

CREATE TABLE tasks (
    id integer NOT NULL DEFAULT nextval('tasks_seq'),
	status BOOLEAN NOT NULL,
	title  VARCHAR(100) NOT NULL,
	lmt DATE NOT NULL
);
ALTER SEQUENCE tasks_seq 
OWNED BY tasks.id
