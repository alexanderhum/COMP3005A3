README

Student Name: Alexander Hum
Student Number: 101180821

Explanation of Functions:

getAllStudents() - The function prints all the students within the Students table.

addStudent("Alex", "Hum", "alex.hum@example.com", "2024-01-01") - The function adds a student to the Students table.

updateStudentEmail(36, "changed@example.com") - The function updates a students email to the Students table.

deleteStudent(36) - The function deletes a students from the Students table.

How to run the application:
Step 1: Download and open up the project
Step 2: In main, uncomment out the code
Step 3: Run the main method

YouTube Video Demonstration: https://youtu.be/U1PPEeVyhTw

Database Creation Scripts:

CREATE TABLE students (
    student_id         SERIAL,
    first_name         VARCHAR(255) NOT NULL,
    last_name          VARCHAR(255) NOT NULL,
    email              VARCHAR(255) UNIQUE NOT NULL,
    enrollment_date    DATE,
    PRIMARY KEY (student_id)
);

INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');
