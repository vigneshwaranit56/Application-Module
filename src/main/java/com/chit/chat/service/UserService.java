package com.chit.chat.service;

import org.springframework.web.multipart.MultipartFile;

import com.chit.chat.entity.UsersEntity;

public interface UserService {

	UsersEntity get(int username);

	void delete(int username);

	boolean existsById(int username);

	UsersEntity save(UsersEntity user);

	UsersEntity uploadImage(int username, MultipartFile file);
	

}
