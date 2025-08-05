package com.devotel.profileservice.service.Impl;

import com.devotel.profileservice.exception.ProfileNotFoundException;
import com.devotel.profileservice.exception.UserNotFoundException;
import com.devotel.profileservice.repository.ProfileRepository;
import com.devotel.profileservice.domain.Profile;
import com.devotel.profileservice.dto.ProfileDto;
import com.devotel.profileservice.dto.UserDto;
import com.devotel.profileservice.service.ProfileService;
import com.devotel.profileservice.soap.UserSoapClient;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {


    private final UserSoapClient userSoapClient;

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(UserSoapClient userSoapClient, ProfileRepository profileRepository) {
        this.userSoapClient = userSoapClient;
        this.profileRepository = profileRepository;
    }

    @Override
    public ProfileDto getProfileWithUser(Long profileId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found"));

        UserDto user = userSoapClient.getUserById(profile.getUserId());
        if (user == null) throw new UserNotFoundException("User not found via SOAP");

        ProfileDto result = new ProfileDto();
        result.setProfileId(profile.getId());
        result.setBio(profile.getBio());
        result.setLocation(profile.getLocation());
        result.setAge(profile.getAge());

        result.setUserId(user.getId());
        result.setUserName(user.getName());
        result.setUserEmail(user.getEmail());

        return result;
    }
}
