package xyz.dahun.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue
    private Long Id;
    private String username;
    private String email;
    private String age;
    private String role;
    private String password;
}
