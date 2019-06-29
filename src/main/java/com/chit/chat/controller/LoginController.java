package com.chit.chat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chit.chat.entity.UsersEntity;

@RestController
public class LoginController {
	
	@GetMapping("/login")
	public ResponseEntity<Void> login(@RequestParam("useranme") String username,@RequestParam("password") String Password ){
		
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

}
