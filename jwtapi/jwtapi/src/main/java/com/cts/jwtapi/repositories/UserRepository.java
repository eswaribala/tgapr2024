package com.cts.jwtapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.jwtapi.models.User;

public interface UserRepository extends JpaRepository<User,String>{

}
