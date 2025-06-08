CREATE TABLE IF NOT EXISTS tasks
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    name           VARCHAR(32),
    status         VARCHAR(16),
    priority       INTEGER DEFAULT 5,
    project_id     BIGINT DEFAULT NULL,
    user_id        BIGINT DEFAULT NULL,
    due_date       TIMESTAMP WITHOUT TIME ZONE,
    created_date   TIMESTAMP WITHOUT TIME ZONE,

    CONSTRAINT PKTasks PRIMARY KEY (id),
    CONSTRAINT FKTasksProject FOREIGN KEY (project_id) REFERENCES projects (id),
    CONSTRAINT FKTasksUser FOREIGN KEY (user_id) REFERENCES users (id)
);