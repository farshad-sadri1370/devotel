package com.devotel.profileservice.service;

import com.devotel.profileservice.dto.ProfileDto;
import org.springframework.stereotype.Service;


@Service
public interface ProfileService {

    ProfileDto getProfileWithUser(Long profileId);
}
