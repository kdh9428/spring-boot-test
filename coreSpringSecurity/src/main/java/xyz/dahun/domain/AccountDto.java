package xyz.dahun.domain;

import lombok.Data;

@Data
public class AccountDto {

    private Long Id;
    private String username;
    private String email;
    private String age;
    private String role;
    private String password;
}
