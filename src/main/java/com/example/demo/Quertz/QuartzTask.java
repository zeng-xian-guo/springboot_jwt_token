package com.example.demo.Quertz;

import com.example.demo.Entity.Task;
import com.example.demo.Service.QuertzTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(value = 1)
public class QuartzTask implements CommandLineRunner {
    @Autowired
    private QuertzTaskService quertzTaskService;
    @Autowired
    private QuertzManage quertzManage;
    @Override
    public void run(String... arg0) throws Exception {
        List<Task> taskList = quertzTaskService.queryQuertzTask();
        for (Task task : taskList) {
            quertzManage.addJob(task);
        }

    }
}
