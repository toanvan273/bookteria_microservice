package com.devteria.profile.service;

import com.devteria.profile.dto.request.ProfileCreationRequest;
import com.devteria.profile.dto.response.UserProfileResponse;
import com.devteria.profile.entity.UserProfile;
import com.devteria.profile.mapper.UserProfileMapper;
import com.devteria.profile.repository.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    public UserProfileResponse createUserProfile(ProfileCreationRequest request){
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        return userProfileMapper.
                toUserProfileResponse(userProfileRepository.save(userProfile));
    }

//    public List<UserProfileResponse> getProfiles(){
//        return userProfileRepository.findAll().stream()
//                .map(userProfile -> userProfileMapper.toUserProfileResponse(userProfile)).collect(Collectors.toList());
//    }

    public UserProfileResponse getProfile(String id) {
        return userProfileRepository.findById(id)
                .map(userProfileMapper::toUserProfileResponse)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

}
