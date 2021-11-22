CREATE TABLE IF NOT EXISTS  employee (
    employee_id   SERIAL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    departament_id INTEGER,
    job_title VARCHAR(20),
    gender VARCHAR(20),
    date_of_birth TIMESTAMP
);







