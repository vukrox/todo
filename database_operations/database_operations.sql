
-- Creating the table of accounts
CREATE TABLE IF NOT EXISTS account
(
account_id INTEGER PRIMARY KEY NOT NULL,
account_login VARCHAR (128) NOT NULL,
account_password VARCHAR (128) NOT NULL,
task_id INTEGER FOREIGN KEY NOT NULL REFERENCES task(task_id)
);

CREATE TABLE IF NOT EXISTS task
(
task_id INTEGER PRIMARY KEY NOT NULL;
task_name VARCHAR (128);
task_description VARCHAR (512);
start_task DATE,
end_task DATE,
isCompleted BOOLEAN DEFAULT FALSE
);