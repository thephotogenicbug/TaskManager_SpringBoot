package com.naveen.taskmanager.service;


import com.naveen.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;
    private SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyy-MM-dd");

    // add task
   public TaskEntity addTask(String title, String description, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(deadlineFormatter.parse(deadline));
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

    // edit tasks
    public TaskEntity updateTask(int id, String description, String deadline, Boolean completed) throws ParseException{
       TaskEntity task = getTaskById(id);
       if(task == null){
           return null;
       }
       if(description != null){
           task.setDescription(description);
       }
        if(deadline != null){
            task.setDeadline(deadlineFormatter.parse(deadline));
        }
       if(completed != null){
           task.setCompleted(completed);
       }

       return task;
    }
}
