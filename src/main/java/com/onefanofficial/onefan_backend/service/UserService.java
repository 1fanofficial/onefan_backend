package com.onefanofficial.onefan_backend.service;

import com.onefanofficial.onefan_backend.model.data.UserDetails;
import com.onefanofficial.onefan_backend.model.repository.UserDetailsRepo;
import com.onefanofficial.onefan_backend.model.request.UserDetailsRequest;
import com.onefanofficial.onefan_backend.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDetailsRepo userDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;


    public UserResponse saveUserDetails(UserDetailsRequest userDetailsRequest){
        UserDetails userDetails = modelMapper.map(userDetailsRequest,UserDetails.class);
        userDetailsRepository.save(userDetails);
        return modelMapper.map(userDetails,UserResponse.class);
    }

}
