package com.devotel.userservice.domain;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Size(max = 100)
    private String email;
}
