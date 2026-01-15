package edu.practice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ServiceStatus {
    @Id @GeneratedValue
    private Long id;
    private Long serviceId;
    private String status;
    private LocalDateTime time;
    public ServiceStatus(){}
    public ServiceStatus(Long s,String st){
        serviceId=s; status=st; time=LocalDateTime.now();
    }
    public String getStatus(){return status;}
    public LocalDateTime getTime(){return time;}
}