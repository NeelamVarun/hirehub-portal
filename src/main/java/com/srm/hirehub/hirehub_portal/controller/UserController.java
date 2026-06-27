package com.srm.hirehub.hirehub_portal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm.hirehub.hirehub_portal.entity.LoginDTO;
import com.srm.hirehub.hirehub_portal.entity.UserDTO;
import com.srm.hirehub.hirehub_portal.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/register")
	public String createUser(@RequestBody UserDTO user){
	 return service.createUser(user);
	
	}
	
	@PostMapping("/login")
	public String createLogin(@RequestBody LoginDTO login) {
		return service.validateLogin(login);
	} 	 
}
