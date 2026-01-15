package edu.practice.repo;
import edu.practice.entity.MonitoredService;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ServiceRepo extends JpaRepository<MonitoredService,Long>{}