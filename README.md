# Task Tracker — OpenMapper Demo

A task tracking REST API built with **Spring Boot 3.5** and **[OpenMapper](https://github.com/padmeamd/open-mapper/)** ORM, backed by **PostgreSQL 17**.

## Prerequisites

- Java 17+
- Maven
- PostgreSQL 17
- OpenMapper installed to maven local:
  ```bash
  git clone git@github.com:padmeamd/open-mapper.git && cd open-mapper && mvn install
  ```

## Database Setup

1. Create the database:
   ```sql
   CREATE DATABASE task_tracker;
   ```

2. Run the schema:
   ```bash
   psql -U postgres -d task_tracker -f src/main/resources/db/schema.sql
   ```

3. Update `src/main/resources/application.properties` with your DB credentials if needed.

## Run

```bash
mvn spring-boot:run
```

The API starts on `http://localhost:8080`.

## API Endpoints

### Users
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/users` | List all users |
| GET | `/api/users/{id}` | Get user by ID |
| GET | `/api/users/{id}/tasks` | Get user with assigned tasks (projection) |
| POST | `/api/users` | Create user |
| PUT | `/api/users/{id}` | Update user |
| DELETE | `/api/users/{id}` | Delete user |

### Tasks
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/tasks` | List all tasks |
| GET | `/api/tasks?status=TODO` | Filter by status |
| GET | `/api/tasks?executorId=1` | Filter by executor |
| GET | `/api/tasks/{id}` | Get task detail with sub-tasks |
| GET | `/api/tasks/{id}/subtasks` | List sub-tasks |
| POST | `/api/tasks` | Create task |
| PATCH | `/api/tasks/{id}/status` | Update status |
| PATCH | `/api/tasks/{id}/executor` | Assign executor |
| DELETE | `/api/tasks/{id}` | Delete task |

### Projects
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/projects` | List all projects |
| GET | `/api/projects/{id}` | Get project by ID |
| GET | `/api/projects/{id}/overview` | Project statistics (projection) |
| GET | `/api/projects/{id}/members` | List project members |
| GET | `/api/projects/{id}/tasks` | List project tasks |
| POST | `/api/projects` | Create project |
| POST | `/api/projects/{id}/members` | Add member |
| DELETE | `/api/projects/{id}/members/{userId}` | Remove member |
| DELETE | `/api/projects/{id}` | Delete project |

## Projections

The API demonstrates different response shapes:
- **UserSummary** — basic user info, no tasks
- **UserWithTasks** — user + flat task list (no sub-tasks)
- **TaskSummary** — compact task (id, title, status, type, tags)
- **TaskDetail** — full task with sub-tasks joined
- **ProjectOverview** — project with computed statistics (total/finished/unfinished tasks, member count)

## Testing

Import `postman/task-tracker.postman_collection.json` into Postman to test all endpoints.
