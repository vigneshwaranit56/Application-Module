package com.chit.chat.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chit.chat.entity.MessageEntity;
import com.chit.chat.model.Messages;
import com.chit.chat.service.MessageService;

@RestController
@RequestMapping("/messaage")
public class MessageController {
	
	@Autowired
	MessageService messageService;

	
	@GetMapping("/{troopId}")
	public ResponseEntity<List<Messages>> getMessagesByTroopId(@PathVariable("troopId") int troopId){
		
		List<Messages> list = messageService.getAllByTroop(troopId);
		
		return new ResponseEntity<List<Messages>>(list,HttpStatus.OK);
		
	}
	
	@PostMapping()
	public ResponseEntity<Void> createMessage( Messages message){
		 messageService.save(message);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{troopId}")
	public ResponseEntity<Void> deleteMessageByTroopId(@PathVariable("troopId") int troopId){
		
		messageService.deleteAllByTroop(troopId);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{sender}/{receiver}")
	public ResponseEntity<List<Messages>> getMessageBySenderAndReceiver(@PathVariable("sender") int sender,@PathVariable("receiver") int receiver){
		
		List<Messages> list =messageService.getMessageBySenderAndReceiver(sender, receiver);
		
		return new ResponseEntity<List<Messages>>(list,HttpStatus.OK);		

	}
	
	@DeleteMapping("/{sender}/{receiver}")
	public ResponseEntity<Void> deleteMessageBySenderAndReceiver(@PathVariable("sender") int sender,@PathVariable("receiver") int receiver){
		
		messageService.deleteMessageBySenderAndReceiver(sender, receiver);
		
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}

		
	

}
