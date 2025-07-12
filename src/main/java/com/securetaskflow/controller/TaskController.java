package com.securetaskflow.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.securetaskflow.entity.Task;
import com.securetaskflow.repository.TaskRepository;
import com.securetaskflow.util.UserUtil;

import lombok.RequiredArgsConstructor;

import java.util.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

	private final TaskRepository taskRepository;

	// ✅ Create Task - ADMIN only using hasRole()
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public Task createTask(@RequestBody Task task) {
		String username = UserUtil.getLoggedInUsername(); // comes from Spring Security context
	    task.setCreatedBy(username); // 🔐 Secure audit info
	    return taskRepository.save(task);
	}

	// ✅ View all tasks - USER or ADMIN using hasAuthority()
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	// ✅ Just a demo endpoint for interview example
	@GetMapping("/status")
	@PreAuthorize("hasRole('USER')")
	public String getTaskStatus() {
		return "This is task status. Accessible to ROLE_USER";
	}
}