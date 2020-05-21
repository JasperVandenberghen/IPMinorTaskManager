package com.taskmanager.repository;

import com.taskmanager.domain.SubTask;
import com.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface SubTaskRepoJPA extends JpaRepository<SubTask, Long> {

}
