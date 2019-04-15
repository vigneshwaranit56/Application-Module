//package com.chit.chat.controller;
//
//import java.security.Principal;
//import java.util.HashMap;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.messaging.simp.annotation.SendToUser;
//import org.springframework.stereotype.Controller;
//
//import com.chit.chat.dao.UserDAO;
//import com.chit.chat.model.ChatMessage;
//
//@Controller
//@Transactional
//public class ChatController {
//
//	@Autowired
//private 	UserDAO userdao;
//
//	@Autowired
//	private SimpMessagingTemplate simpMessagingTemplate;
//
//	@PersistenceContext
//private	EntityManager entityManager;
//
////	@GetMapping("/user/{id}")
////	public ResponseEntity<String> test(@PathVariable int id) {
////
////		Users user = new Users();
////		user.setEmail("vignesh@gmail.com");
////		user.setPassword("{noop}1234");
////		user.setUsername("vignesh" + id);
////		user.setPicture(null);
////		user.setEnabled((byte) 1);
////
////		userdao.save(user);
////		
////	
////		return new ResponseEntity<String>("success", HttpStatus.OK);
////
////	}
//
//	private HashMap<String, String> users = new HashMap<String, String>();
//
//	@MessageMapping("/chat.sendMessage")
//	@SendToUser("/queue/reply")
//	public ChatMessage sendMessage(Message<Object> message, @Payload ChatMessage chatMessage, Principal principal) {
//
//		// System.out.println("Stomp client called");
//		// Principal principal =
//		// message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER,
//		// Principal.class);
//		// String authedSender = principal.getName();
//		// chatMessage.setSender(authedSender);
//		// String recipient = chatMessage.getReceiver();
//		// System.out.println("authedSender : "+authedSender +" --- recipient ::
//		// "+recipient);
//		// if (!authedSender.equals(recipient)) {
//		// System.out.println("inside if loop");
//		// simpMessagingTemplate.convertAndSendToUser(authedSender,
//		// "/topic/reply", chatMessage);
//		// }
//		//
//		// simpMessagingTemplate.convertAndSendToUser(recipient,
//		// "/topic/public", chatMessage);
//
//		return chatMessage;
//
//	}
//
//	@MessageMapping("/chat.sendMessagegroup")
//	@SendTo("/topic/public")
//	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
//
//		return chatMessage;
//
//	}
//
//	@MessageMapping("/chat.addUser")
//	@SendTo("/topic/public")
//	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
//		// Add username in web socket session
//		users.put(chatMessage.getSender(), headerAccessor.getSessionId());
//		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//		return chatMessage;
//	}
//
//}
