package com.example.demo.Service.Impl;

import com.example.demo.Entity.Task;
import com.example.demo.Quertz.QuertzManage;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Service.QuertzTaskService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuertzTaskServiceImpl implements QuertzTaskService {
    @Autowired
    private TaskRepository  taskRepository;
    @Autowired
    private QuertzManage quertzManage;
    @Override
    public List<Task> queryQuertzTask() {
        return taskRepository.findByJobStatus();
    }

    @Override
    public void pauseTaskById(String id) throws SchedulerException {
        Optional<Task> task = taskRepository.findById(id);
        quertzManage.pauseJob(task.get().getJobName(),task.get().getJobGroup());
    }

    @Override
    public void resumeTaskById(String id) throws SchedulerException {
        Optional<Task> task = taskRepository.findById(id);
        quertzManage.resumeJob(task.get().getJobName(),task.get().getJobGroup());
    }
}
