package com.chit.chat.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chit.chat.dao.UserDAO;
import com.chit.chat.entity.UsersEntity;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserDAO userDAO;
	

	@Override
	public UsersEntity get(int userid) {
		
		return userDAO.findById(userid).get();
	}

	@Override
	public void delete(int userId) {

		if (existsById(userId))

			userDAO.delete(get(userId));
		else
			try {
				throw new Exception("username doesn't exist");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public boolean existsById(int userId) {
		return userDAO.existsById(userId);
	}

	@Override
	public UsersEntity save(UsersEntity user) {
		return userDAO.save(user);
	}

	@Override
	public UsersEntity uploadImage(int username, MultipartFile file) {

		UsersEntity user = get(username);
		try {
			user.setPicture(file.getBytes());
			userDAO.save(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}


	
}
