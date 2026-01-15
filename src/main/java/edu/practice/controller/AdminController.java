package edu.practice.controller;

import edu.practice.entity.MonitoredService;
import edu.practice.repo.ServiceRepo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final ServiceRepo repo;
    public AdminController(ServiceRepo r){repo=r;}

    @PostMapping("/services")
    public MonitoredService add(@RequestBody MonitoredService s){
        return repo.save(s);
    }
}