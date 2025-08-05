package com.devotel.profileservice.dto;


import lombok.Data;

@Data
public class ProfileDto {

    private Long profileId;
    private String bio;
    private String location;
    private Integer age;
    private Long userId;
    private String userName;
    private String userEmail;


}
