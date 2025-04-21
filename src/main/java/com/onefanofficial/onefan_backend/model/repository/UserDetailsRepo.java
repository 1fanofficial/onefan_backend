package com.onefanofficial.onefan_backend.model.repository;

import com.onefanofficial.onefan_backend.model.data.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails,String> {

}
