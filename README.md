# taskmgr-spring
# TASK MANAGER

## Problem Statement
Design and develop an in memory (*NO DATABASE*) web application for managing personal tasks and notes within a given task.

---

## Requirements
- CRUD capabilities for tasks and for **NOTES** within a **TASK**. - *Notes can be considered as descriptors to that task*
- A **TASK** should be able to have multiple **NOTES** linked to it. Initially, a not can only be linked to one task. - *i.e. a TASK has many NOTES*
- A simple UI for the user to be able to view and interact with **TASKS** and **NOTES**

---

## Basic Flow
### *Subject to changes basis of how you want the overall UX to be*
1. Initial page where user can view current tasks and also a form to create a new one along with notes inside it
2. Capability to click on Edit/Delete buttons against each task for one to be able to Modify/Delete a task
3. Capability to be able to see notes within a task after clicking on it
4. Capability to remove or add notes in existing tasks

____________________________________________________________________________________________________________________________________________________________________________________________
# Task Manager App

## JSON Entities

### Task
    {
	    "id": 31,
	    "title": "I am a task!",
	    "description": "This is the task description",
	    "deadline": "dd/mm/yyyy",
      "notes": [
        {
          "title": "random note title",
          "body": "I am the note body"
        },
        {
          "title": "random note title",
          "body": "I am the note body"
        },
        {
          "title": "random note title",
          "body": "I am the note body"
        }
      ],
      "completed": false
    }

## API Endpoints
---- END POINTS IN TASK CONTROLLERS -----
### `POST /tasks` 
Create a new task  

### `GET /tasks`
Get all tasks
Available filters - 
- `/tasks?completed=true/false`

### `GET /tasks/{task_id}`
Get the details of a particular task including notes

### `PATCH /tasks/{task_id}`
Edit a task - Add / Remove notes from the task. Mark a task completed.

### `PATCH /tasks/{task_id}`

### `DELETE /tasks/{task_id}`
Delete a particular task

---- END POINTS IN NOTES CONTROLLERS -----

### `GET  /tasks/{task_id}/notes`
Fetch all the notes under a particular task 

### `POST  /tasks/{task_id}/notes` 
Create a new note under the task with given task id 

### `DELETE /tasks/{task_id}/notes/{notes_id}`
Delete a note
