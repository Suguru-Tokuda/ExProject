package com.executor.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.Task;
import com.executor.domain.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaksController {
	
	@Autowired
	TaskRepository taskRepository;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Iterable<Task> getTasks(@RequestParam(value="projectId", required=false) Long projectId, @RequestParam(value="userId", required=false) Long userId) {
		List<Task> taskList = new ArrayList<>();
		if (projectId == null && userId == null)
			return taskRepository.findAll();
		else if (projectId != null && userId != null) {
			return taskRepository.findByIds(userId, projectId);
		} else {
			List<Task> tempList = null;
			Iterator<Task> iterator = null;
			if (projectId != null) {
				tempList = taskRepository.findByProjectId(projectId);
				iterator = tempList.iterator();
				while (iterator.hasNext()) {
					Task task = iterator.next();
					if (!taskList.contains(task))
						taskList.add(task);
				}
			}
			if (userId != null) {
				tempList = taskRepository.findByUserId(userId);
				iterator = tempList.iterator();
				while(iterator.hasNext()) {
					Task task = iterator.next();
					if (!taskList.contains(task))
						taskList.add(task);
				}
			}
		}
		return taskList;
	}
	
	@RequestMapping(value="/{taskId}", method=RequestMethod.GET)
	public Optional<Task> getTask(@PathVariable("taskId") String taskId) {
		return taskRepository.findById(Long.parseLong(taskId));
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Task createTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public Task updateTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	@RequestMapping(value="/setUser", method=RequestMethod.POST)
	public Task setUser(@RequestParam(value="userId", required=true) Long userId, @RequestParam(value="taskId", required=true) Long taskId) {
		return taskRepository.setUserId(userId, taskId);
	}			
	
	@RequestMapping(value="/{taskId}", method=RequestMethod.DELETE)
	public void deleteTask(@PathVariable("taskId") Long taskId) {
		taskRepository.deleteById(taskId);
	}

}
