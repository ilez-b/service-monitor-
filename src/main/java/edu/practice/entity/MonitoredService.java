package edu.practice.entity;

import jakarta.persistence.*;

@Entity
public class MonitoredService {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String url;
    public Long getId(){return id;}
    public String getName(){return name;}
    public String getUrl(){return url;}
    public void setName(String n){name=n;}
    public void setUrl(String u){url=u;}
}