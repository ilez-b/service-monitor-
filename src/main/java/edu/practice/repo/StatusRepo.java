package edu.practice.repo;
import edu.practice.entity.ServiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface StatusRepo extends JpaRepository<ServiceStatus,Long>{
    List<ServiceStatus> findByServiceIdAndTimeBetween(Long id, LocalDateTime f, LocalDateTime t);
}