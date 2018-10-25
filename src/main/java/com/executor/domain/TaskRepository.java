package com.executor.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository <Task, Long> {
	
	List<Task> findByTaskId(Long taskId);
	@Query(value="SELECT * FROM Tasks t JOIN TaskAssignments ta ON t.taskId = ta.taskId WHERE ta.projectId = ?1", nativeQuery=true)
	List<Task> findByProjectId(Long projectId);
	@Query(value="SELECT * FROM Tasks t JOIN TaskAssignments ta ON t.taskId = ta.taskId WHERE ta.userId = ?1", nativeQuery=true)
	List<Task> findByUserId(Long userId);
	@Query(value="SELECT * FROM Tasks t JOIN TaskAssignment ta ON t.taskId = ta.taskId WHERE ta.userId = ?1 AND ta.projectId = ?2", nativeQuery=true)
	List<Task> findByIds(Long userId, Long projectId);
}
