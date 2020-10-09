package com.example.demo.Controller;

import com.example.demo.Entity.Cache;
import com.example.demo.Service.QuertzTaskService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class QuertzTaskController {
    @Autowired
    private QuertzTaskService quertzTaskService;

    @GetMapping("/pause/{id}")
    @ResponseBody
    public void pauseJob(@PathVariable(value = "id") String id) throws SchedulerException {
        quertzTaskService.pauseTaskById(id);
    }

    @GetMapping("/resume/{id}")
    @ResponseBody
    public void resumeJob(@PathVariable(value = "id") String id) throws SchedulerException {
        quertzTaskService.resumeTaskById(id);
    }
}
