package com.cts.jwtapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.jwtapi.models.Role;
import com.cts.jwtapi.models.User;

import io.jsonwebtoken.lang.Collections;
@Service
public class UserAuthService implements UserDetailsService{
    @Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userService.getUserByUserName(username);
		
		if(user == null)
			throw new UsernameNotFoundException("User Not Available");
		
		else {
			
		 List<Role> roles=this.userService.getUserRoles(username);
		 List<GrantedAuthority> grantedAuthorities=roles.stream().map(r->{
		            	 return new SimpleGrantedAuthority(r.getRoleName());
		             }).collect(Collectors.toList());
		 
		 return new org.springframework.security.core.userdetails.
				 User(user.getUserName(),user.getPassword(),grantedAuthorities);		
		}
			

	}
	public User getUserByUsername(String username) {
		User user= userService.getUserByUserName(username);

		if (user != null) {

			return user;
		}

		return null;
	}

}
