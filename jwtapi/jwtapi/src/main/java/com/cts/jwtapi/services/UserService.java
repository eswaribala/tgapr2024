package com.cts.jwtapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.jwtapi.models.Role;
import com.cts.jwtapi.models.User;
import com.cts.jwtapi.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
	private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    public User saveUser(User user) {
    	User testUser=getUserByUserName(user.getUserName());
    	if(testUser == null)
    	{
    	 user.setPassword(passwordEncoder.encode(user.getPassword()));
    	 return this.userRepository.save(user);
    	}else
    	{
    		return null;
    	}
    	
    	
    }
    
    
    public List<User> getAllUsers(){
    	return this.userRepository.findAll();
    	
    }
    
    public User getUserByUserName(String userName) {
    	return this.userRepository.findById(userName).orElse(null);
    }
    
    
    public List<Role> getUserRoles(String userName){
    	User user= getUserByUserName(userName);
    	return user.getRoles();
    }
    
    
}
