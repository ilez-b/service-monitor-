package edu.practice.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String role;
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public String getRole(){return role;}
}