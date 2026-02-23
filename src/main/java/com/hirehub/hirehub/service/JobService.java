package com.hirehub.hirehub.service;

import com.hirehub.hirehub.model.Job;
import com.hirehub.hirehub.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> getOpenJobs() {
        return jobRepository.findByStatus("OPEN");
    }

    public List<Job> getJobsBySkill(String skill) {
        return jobRepository.findBySkillsContaining(skill);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

}