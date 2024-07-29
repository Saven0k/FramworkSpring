create table tasks
(
    id          INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    status      VARCHAR(50) NOT NULL,
    discription VARCHAR(50) NOT NULL,
    task_date DATE DEFAULT CURRENT_DATE
);