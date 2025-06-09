package com.naveen.taskmanager.service;


import com.naveen.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;

    // add task
   public TaskEntity addTask(String title, String description, String deadline){
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
//        task.setDeadline(new Date(deadline)); // validate date format YYY-MM-DD
        task.setCompleted(false);
        tasks.add(task);
        taskId++;
        return task;
    }

    // get task
  public ArrayList<TaskEntity> getTasks(){
        return tasks;
    }

    // get task by id
   public TaskEntity getTaskById(int id){
        for (TaskEntity task : tasks){
            if(task.getId() == id){
                return task;
            }

        }
        return null;
    }
}
