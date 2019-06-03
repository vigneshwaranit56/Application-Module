package com.chit.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chit.chat.entity.UsersEntity;
import com.chit.chat.exception.handler.NotFoundException;
import com.chit.chat.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	// (required=true)
	// @Qualifier("userServiceImplementation")

	UserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<UsersEntity> getuser(@PathVariable int userId) {

		UsersEntity user = userService.get(userId);

		if (user == null)
			throw new NotFoundException("user is not found, check your user id");

		return new ResponseEntity<UsersEntity>(user, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable int userId) {

		userService.delete(userId);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<UsersEntity> updateUser( UsersEntity user) {
		if (userService.existsById(user.getId())) {
			user = userService.save(user);
		} else {

			throw new NotFoundException("user is not found, check your user id");

		}

		return new ResponseEntity<UsersEntity>(user, HttpStatus.ACCEPTED);

	}

	@PostMapping
	public ResponseEntity<UsersEntity> createuser( UsersEntity user) {

		if (!userService.existsById(user.getId()) && user.getEmail() != null) {

			user = userService.save(user);
		} else
			throw new NotFoundException("user is not found, check your user id");

		return new ResponseEntity<UsersEntity>(user, HttpStatus.CREATED);
	}

	@PostMapping("/image/{userId}")
	public ResponseEntity<Void> uploadFile(@PathVariable int userId, @RequestParam("file") MultipartFile file) {

		userService.uploadImage(userId, file);

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
