
CREATE TABLE employee (
        employee_id serial NOT NULL,
        job_title varchar (50) NOT NULL,
        first_name varchar (50) NOT NULL,
        last_name varchar (50) NOT NULL,
        gender varchar (6) NOT NULL,
        date_of_birth date NOT NULL,
        hire_date date NOT NULL,
        department_id integer NOT NULL,
        CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id)
        );

CREATE TABLE department (
        department_id serial NOT NULL,
        department_name varchar (50),
        CONSTRAINT pk_department_department_id PRIMARY KEY (department_id)
        );

CREATE TABLE project (
        project_number serial NOT NULL,
        project_name varchar (50) NOT NULL,
        project_start_date date,
        CONSTRAINT pk_project_project_number PRIMARY KEY (project_number)
        );
        
CREATE TABLE project_organizer (
        employee_id integer NOT NULL,
        project_number integer NOT NULL,
        CONSTRAINT pk_project_organizer_employee_id_project_number PRIMARY KEY (employee_id, project_number)
        );
              

ALTER TABLE employee
ADD FOREIGN KEY (department_id)
REFERENCES department(department_id);

ALTER TABLE project_organizer
ADD FOREIGN KEY (employee_id)
REFERENCES employee(employee_id);

ALTER TABLE project_organizer
ADD FOREIGN KEY (project_number)
REFERENCES project(project_number);

INSERT INTO project (project_name, project_start_date)
VALUES ('Constantine', '2020-06-14');

INSERT INTO project (project_name, project_start_date)
VALUES ('Superbowl', '2020-07-14');

INSERT INTO project (project_name, project_start_date)
VALUES ('Save The World', '2020-08-14');

INSERT INTO project (project_name, project_start_date)
VALUES ('Time Travel', '2020-09-14');

INSERT INTO department (department_name)
VALUES ('Athletics');

INSERT INTO department (department_name)
VALUES ('Investigative');

INSERT INTO department (department_name)
VALUES ('Mythological');


INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, hire_date, department_id)
VALUES ('Surfer', 'Johhny', 'Utah', 'Male', '1960-05-01', '1980-01-01', 1);

INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, hire_date, department_id)
VALUES ('Detective', 'Jack', 'Travern', 'Male', '1961-06-10', '1981-03-05', 2);

INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, hire_date, department_id)
VALUES ('Stuntman', 'Duke', 'Caboom', 'Male', '1962-08-13', '1990-10-01', 1);

INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, hire_date, department_id)
VALUES ('Detective', 'Jon', 'Constantine', 'Male', '1980-02-18', '2010-07-012', 2);

INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, hire_date, department_id)
VALUES ('Quarterback', 'Shane', 'Falco', 'Male', '1990-11-11', '2015-12-12', 1);

INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, hire_date, department_id)
VALUES ('Professor', 'Ted', 'Logan', 'Male', '1985-4-20', '2005-01-24', 3);

INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, hire_date, department_id)
VALUES ('Estate Agent', 'Jonathan', 'Harker', 'Male', '1897-05-01', '2020-01-01', 3);

INSERT INTO employee (job_title, first_name, last_name, gender, date_of_birth, hire_date, department_id)
VALUES ('President', 'Sarah', 'Connor', 'Female', '1988-05-16', '2010-02-01', 2);


INSERT INTO project_organizer (employee_id, project_number)
VALUES ((SELECT employee_id FROM employee WHERE last_name = 'Utah'), (SELECT project_number FROM project WHERE project_name = 'Save The World'));

INSERT INTO project_organizer (employee_id, project_number)
VALUES ((SELECT employee_id FROM employee WHERE last_name = 'Falco'), (SELECT project_number FROM project WHERE project_name = 'Superbowl'));

INSERT INTO project_organizer (employee_id, project_number)
VALUES ((SELECT employee_id FROM employee WHERE last_name = 'Constantine'), (SELECT project_number FROM project WHERE project_name = 'Constantine'));

INSERT INTO project_organizer (employee_id, project_number)
VALUES ((SELECT employee_id FROM employee WHERE last_name = 'Logan'), (SELECT project_number FROM project WHERE project_name = 'Time Travel'));

