package com.assma.taskflow.controller;

import com.assma.taskflow.model.Task;
import com.assma.taskflow.model.TaskStatus;
import com.assma.taskflow.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(
        name = "Task Management",
        description = "Endpoints for creating, reading, updating, deleting and filtering tasks"
)
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(
            summary = "Get all tasks",
            description = "Returns all tasks stored in the database"
    )
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Operation(
            summary = "Get task by ID",
            description = "Returns a single task using its unique ID"
    )
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @Operation(
            summary = "Create a new task",
            description = "Creates and stores a new task"
    )
    @PostMapping
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.createTask(task);
    }

    @Operation(
            summary = "Update a task",
            description = "Updates an existing task using its ID"
    )
    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @Valid @RequestBody Task updatedTask
    ) {
        return taskService.updateTask(id, updatedTask);
    }

    @Operation(
            summary = "Delete a task",
            description = "Deletes a task using its ID"
    )
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @Operation(
            summary = "Filter tasks by completion status",
            description = "Returns tasks filtered by completed=true or completed=false"
    )
    @GetMapping("/status")
    public List<Task> getTasksByCompleted(@RequestParam boolean completed) {
        return taskService.getTasksByCompleted(completed);
    }

    @Operation(
            summary = "Filter tasks by priority",
            description = "Returns tasks matching a priority such as HIGH, MEDIUM or LOW"
    )
    @GetMapping("/priority")
    public List<Task> getTasksByPriority(@RequestParam String value) {
        return taskService.getTasksByPriority(value);
    }

    @Operation(
            summary = "Search tasks by title",
            description = "Returns tasks whose title contains the specified text"
    )
    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String title) {
        return taskService.searchTasksByTitle(title);
    }

    @Operation(
            summary = "Filter tasks by status",
            description = "Returns tasks matching TODO, IN_PROGRESS or DONE"
    )
    @GetMapping("/task-status")
    public List<Task> getTasksByStatus(@RequestParam TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }
}