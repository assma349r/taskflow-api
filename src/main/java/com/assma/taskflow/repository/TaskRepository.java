package com.assma.taskflow.repository;

import com.assma.taskflow.model.Task;
import com.assma.taskflow.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByCompleted(boolean completed);

    List<Task> findByPriorityIgnoreCase(String priority);

    List<Task> findByTitleContainingIgnoreCase(String title);

    List<Task> findByStatus(TaskStatus status);
}