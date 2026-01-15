package edu.practice.controller;

import edu.practice.repo.StatusRepo;
import org.springframework.web.bind.annotation.*;
import java.time.*;
import java.util.*;

@RestController
@RequestMapping("/api/metrics")
public class MetricsController {

    private final StatusRepo repo;
    public MetricsController(StatusRepo r){repo=r;}

    @GetMapping("/availability")
    public Map<String,Double> availability(Long serviceId, String from, String to){
        var list = repo.findByServiceIdAndTimeBetween(
          serviceId, LocalDateTime.parse(from), LocalDateTime.parse(to));
        long up = list.stream().filter(s->s.getStatus().equals("UP")).count();
        double perc = list.isEmpty()?0:(up*100.0/list.size());
        return Map.of("availability", perc);
    }
}