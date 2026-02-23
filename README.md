# HireHub - Job Portal Backend

Spring Boot REST API backend for the HireHub AI powered job portal.

## Tech Stack
- Java 17
- Spring Boot 3.5.11
- Spring Security
- Spring Data JPA
- MySQL
- Maven

## Features
- User management with role based access
- Job listing management
- Application tracking system
- AI powered candidate matching via Python Flask microservice
- RESTful API architecture

## API Endpoints
- POST /api/users - Create user
- GET /api/users - Get all users
- POST /api/jobs - Create job
- GET /api/jobs - Get all jobs
- GET /api/jobs/open - Get open jobs
- POST /api/applications - Submit application with AI match score
- GET /api/applications/user/{id} - Get applications by user

## How to Run
1. Install MySQL and create database: CREATE DATABASE hirehub
2. Update application.properties with your MySQL credentials
3. Run HirehubApplication.java
4. API runs on port 8080