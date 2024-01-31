package com.greenhood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.model.LogInDTO;
import com.greenhood.service.AdminLogInServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminLogInController {
	@Autowired
	private AdminLogInServiceImpl adminLogInServiceImpl;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@RequestBody LogInDTO dto) throws AuthorizationException {
		
		String result = adminLogInServiceImpl.logIn(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@DeleteMapping("/logout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws AuthorizationException {
		
		return adminLogInServiceImpl.logOut(key);
		
	}
}
