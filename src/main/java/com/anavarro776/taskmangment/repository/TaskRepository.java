package com.anavarro776.taskmangment.repository;

import com.anavarro776.taskmangment.model.Task;
import com.anavarro776.taskmangment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface TaskRepository extends JpaRepository <Task,Long {
   List<Task> findByUserId(Long userId);
   List <Task> findByStatus(Task.Status status);



}
