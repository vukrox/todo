package com.todo.repository;

import com.todo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

//    @Query("SELECT t FROM task t WHERE t.account_id = :#{#accountId}")
//    List<Task> findAllByAccount(@Param("account_id") UUID accountId);
}
