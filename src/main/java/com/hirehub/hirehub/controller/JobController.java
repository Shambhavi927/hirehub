package com.hirehub.hirehub.controller;

import com.hirehub.hirehub.model.Job;
import com.hirehub.hirehub.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/open")
    public List<Job> getOpenJobs() {
        return jobService.getOpenJobs();
    }

    @GetMapping("/skill/{skill}")
    public List<Job> getJobsBySkill(@PathVariable String skill) {
        return jobService.getJobsBySkill(skill);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return "Job deleted successfully";
    }
}