package com.assma.taskflow.service;

import com.assma.taskflow.exception.TaskNotFoundException;
import com.assma.taskflow.model.Task;
import com.assma.taskflow.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        taskService = new TaskService(taskRepository);
    }

    @Test
    void shouldReturnAllTasks() {

        Task task1 = new Task();
        task1.setTitle("Aprender Spring Boot");

        Task task2 = new Task();
        task2.setTitle("Preparar portfolio");

        when(taskRepository.findAll())
                .thenReturn(List.of(task1, task2));

        List<Task> result = taskService.getAllTasks();

        assertEquals(2, result.size());
        assertEquals("Aprender Spring Boot", result.get(0).getTitle());
        assertEquals("Preparar portfolio", result.get(1).getTitle());
    }

    @Test
    void shouldReturnTaskById() {

        Task task = new Task();
        task.setId(1L);
        task.setTitle("Aprender Spring Boot");

        when(taskRepository.findById(1L))
                .thenReturn(Optional.of(task));

        Task result = taskService.getTaskById(1L);

        assertEquals(1L, result.getId());
        assertEquals("Aprender Spring Boot", result.getTitle());
    }

    @Test
    void shouldThrowExceptionWhenTaskDoesNotExist() {

        when(taskRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                TaskNotFoundException.class,
                () -> taskService.getTaskById(999L)
        );
    }

    @Test
    void shouldCreateTask() {

        Task task = new Task();
        task.setTitle("Crear portfolio");
        task.setDescription("Preparar GitHub");

        when(taskRepository.save(task))
                .thenReturn(task);

        Task result = taskService.createTask(task);

        assertEquals("Crear portfolio", result.getTitle());
        assertEquals("Preparar GitHub", result.getDescription());

        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void shouldDeleteTask() {

        Task task = new Task();
        task.setId(1L);
        task.setTitle("Tarea para borrar");

        when(taskRepository.findById(1L))
                .thenReturn(Optional.of(task));

        taskService.deleteTask(1L);

        verify(taskRepository, times(1)).delete(task);
    }
}