package com.anavarro776.taskmangment.service;

import java.util.List;
import com.anavarro776.taskmangment.model.Task;
import com.anavarro776.taskmangment.model.User;
import com.anavarro776.taskmangment.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {
@Autowired
private TaskRepository taskRepository;

public List<Task> findAll(){
    return taskRepository.findAll();
}
}
