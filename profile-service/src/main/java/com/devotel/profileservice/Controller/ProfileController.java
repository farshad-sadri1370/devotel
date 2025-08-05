package com.devotel.profileservice.Controller;


import com.devotel.profileservice.dto.ProfileDto;
import com.devotel.profileservice.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ProfileController {


    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> getProfileWithUser(@PathVariable Long id) {
        return ResponseEntity.ok(profileService.getProfileWithUser(id));
    }
}
