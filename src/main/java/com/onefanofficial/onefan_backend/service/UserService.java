package com.onefanofficial.onefan_backend.service;

import com.onefanofficial.onefan_backend.configuration.ExceptionHandler.Exceptions.ResourceNotFoundException;
import com.onefanofficial.onefan_backend.model.data.UserDetails;
import com.onefanofficial.onefan_backend.model.repository.UserDetailsRepo;
import com.onefanofficial.onefan_backend.model.request.UserDetailsRequest;
import com.onefanofficial.onefan_backend.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserDetailsRepo userDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;


    public UserResponse saveUserDetails(UserDetailsRequest userDetailsRequest){
        UserDetails userDetails = modelMapper.map(userDetailsRequest,UserDetails.class);
        userDetails.setCreatedAt(new Date());
        userDetailsRepository.save(userDetails);
        return modelMapper.map(userDetails,UserResponse.class);
    }

    public UserResponse getUserById(String id){
       Optional<UserDetails> userDetails =  userDetailsRepository.findById(UUID.fromString(id));
       if(userDetails.isPresent()){
           return modelMapper.map(userDetails.get(),UserResponse.class);
       }
       throw new ResourceNotFoundException("User details not found");
    }

}
