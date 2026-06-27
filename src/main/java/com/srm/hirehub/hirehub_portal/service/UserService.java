package com.srm.hirehub.hirehub_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srm.hirehub.hirehub_portal.entity.LoginDTO;
import com.srm.hirehub.hirehub_portal.entity.UserDTO;
import com.srm.hirehub.hirehub_portal.entity.UserEntity;
import com.srm.hirehub.hirehub_portal.repository.UserRepository;
import com.srm.hirehub.hirehub_portal.validation.UserException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;

	

	public String createUser(UserDTO userDto) {
		
		String requestedEmail = userDto.getUserEmail();
		
		UserEntity userEntity = repo.getUserByEmail(requestedEmail);//db value
		if(userEntity != null) {
			String errMessage =  "user email id  already exits";
			ValidationMessage msg = new ValidationMessage();
			msg.setErrorMessage(errMessage);
			UserException exp = new UserException(errMessage);
			exp.setValidationMessage(msg);
			throw exp;
		}
		
		UserEntity entity = new UserEntity();
		entity.setEmail(userDto.getUserEmail());
		entity.setName(userDto.getUserName());
		entity.setPassword(userDto.getUserPassword());
		entity.setRole(userDto.getUserRole());
		
		
		repo.save(entity);
		  return "{"
          + "\"message\":\"User created\""
          + "}";
	}
	
	
	public String validateLogin(LoginDTO login) {
		UserEntity entity = repo.getUserByMailAndPassword(login.getLoginEmail(), login.getLoginnPassword());
		
	 if (entity != null) {
		 return "Valid user";
	 }
	 
	 return "Invalid user";
		
	}
	

   
}
