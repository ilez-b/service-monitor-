package edu.practice.service;

import edu.practice.repo.*;
import edu.practice.entity.ServiceStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Scheduler {

    private final ServiceRepo srepo;
    private final StatusRepo repo;
    private final RestTemplate rt = new RestTemplate();

    public Scheduler(ServiceRepo s, StatusRepo r){srepo=s; repo=r;}

    @Scheduled(cron="0 */1 * * * *")
    public void check(){
        srepo.findAll().forEach(s->{
            try{
                var r = rt.getForObject(s.getUrl(), String.class);
                repo.save(new ServiceStatus(s.getId(),"UP"));
            }catch(Exception e){
                repo.save(new ServiceStatus(s.getId(),"DOWN"));
            }
        });
    }
}