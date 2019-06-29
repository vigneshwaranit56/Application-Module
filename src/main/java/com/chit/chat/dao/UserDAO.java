package com.chit.chat.dao;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chit.chat.entity.UsersEntity;

@Repository
public interface UserDAO  extends CrudRepository<UsersEntity, Integer>{

	
    UsersEntity findByUsername(String username);

}
