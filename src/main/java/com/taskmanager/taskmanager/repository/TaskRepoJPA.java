package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepoJPA extends JpaRepository<Task, Long> {
}
