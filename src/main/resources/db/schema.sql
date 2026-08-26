-- Task Tracker Schema for PostgreSQL 17

CREATE TABLE IF NOT EXISTS users (
    id          SERIAL PRIMARY KEY,
    first_name  VARCHAR(100) NOT NULL,
    last_name   VARCHAR(100) NOT NULL,
    email       VARCHAR(255) NOT NULL UNIQUE,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS projects (
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(200) NOT NULL,
    description TEXT,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS project_members (
    project_id  INT NOT NULL REFERENCES projects(id) ON DELETE CASCADE,
    user_id     INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    role        VARCHAR(50) DEFAULT 'member',
    PRIMARY KEY (project_id, user_id)
);

CREATE TABLE IF NOT EXISTS tasks (
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(300) NOT NULL,
    description TEXT,
    status      VARCHAR(50) NOT NULL DEFAULT 'TODO',
    type        VARCHAR(50) NOT NULL DEFAULT 'TASK',
    tags        VARCHAR(500),
    project_id  INT NOT NULL REFERENCES projects(id) ON DELETE CASCADE,
    owner_id    INT REFERENCES users(id) ON DELETE SET NULL,
    executor_id INT REFERENCES users(id) ON DELETE SET NULL,
    parent_id   INT REFERENCES tasks(id) ON DELETE CASCADE,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Seed data
INSERT INTO users (first_name, last_name, email) VALUES
    ('Alice', 'Johnson', 'alice@example.com'),
    ('Bob', 'Smith', 'bob@example.com'),
    ('Carol', 'Williams', 'carol@example.com');

INSERT INTO projects (name, description) VALUES
    ('Platform Rebuild', 'Rebuild the core platform with modern stack'),
    ('Mobile App', 'Cross-platform mobile application');

INSERT INTO project_members (project_id, user_id, role) VALUES
    (1, 1, 'owner'),
    (1, 2, 'member'),
    (1, 3, 'member'),
    (2, 2, 'owner'),
    (2, 3, 'member');

INSERT INTO tasks (title, description, status, type, tags, project_id, owner_id, executor_id, parent_id) VALUES
    ('Set up CI/CD', 'Configure GitHub Actions pipeline', 'IN_PROGRESS', 'TASK', 'devops,infra', 1, 1, 2, NULL),
    ('Write build script', 'Maven build + Docker', 'TODO', 'SUB_TASK', 'devops', 1, 1, 2, 1),
    ('Add deploy stage', 'Deploy to staging env', 'TODO', 'SUB_TASK', 'devops', 1, 1, NULL, 1),
    ('Design DB schema', 'Design normalized schema for v2', 'DONE', 'TASK', 'db,design', 1, 1, 1, NULL),
    ('API authentication', 'Implement JWT auth', 'TODO', 'STORY', 'security,api', 1, 2, 3, NULL),
    ('Login screen', 'Build login UI', 'IN_PROGRESS', 'TASK', 'ui,mobile', 2, 2, 3, NULL),
    ('Push notifications', 'Integrate FCM', 'TODO', 'STORY', 'mobile,notifications', 2, 2, NULL, NULL);
