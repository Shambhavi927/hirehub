package com.hirehub.hirehub.repository;

import com.hirehub.hirehub.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByStatus(String status);
    List<Job> findBySkillsContaining(String skill);
}