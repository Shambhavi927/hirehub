package com.hirehub.hirehub.controller;

import com.hirehub.hirehub.ai.AIMatchingService;
import com.hirehub.hirehub.model.Application;
import com.hirehub.hirehub.model.Job;
import com.hirehub.hirehub.service.ApplicationService;
import com.hirehub.hirehub.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private AIMatchingService aiMatchingService;

    @Autowired
    private JobService jobService;

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        String candidateSkills = application.getCandidateSkills();

        Job job = jobService.getJobById(application.getJob().getId());
        String jobSkills = job != null ? job.getSkills() : null;

        System.out.println("Candidate Skills: " + candidateSkills);
        System.out.println("Job Skills: " + jobSkills);

        if (candidateSkills != null && jobSkills != null) {
            double score = aiMatchingService.getMatchScore(candidateSkills, jobSkills);
            application.setMatchScore(score);
        }

        return applicationService.saveApplication(application);
    }

    @GetMapping("/user/{userId}")
    public List<Application> getApplicationsByUser(@PathVariable Long userId) {
        return applicationService.getApplicationsByUser(userId);
    }

    @GetMapping("/job/{jobId}")
    public List<Application> getApplicationsByJob(@PathVariable Long jobId) {
        return applicationService.getApplicationsByJob(jobId);
    }

    @GetMapping("/status/{status}")
    public List<Application> getApplicationsByStatus(@PathVariable String status) {
        return applicationService.getApplicationsByStatus(status);
    }

    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return "Application deleted successfully";
    }
}