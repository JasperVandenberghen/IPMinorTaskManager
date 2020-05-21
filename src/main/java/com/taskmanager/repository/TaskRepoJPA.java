package com.taskmanager.repository;

import com.taskmanager.domain.SubTask;
import com.taskmanager.domain.Task;
import com.taskmanager.dto.SubTaskDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Component
public interface TaskRepoJPA extends JpaRepository<Task, Long> {

}
