package com.securetaskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securetaskflow.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
