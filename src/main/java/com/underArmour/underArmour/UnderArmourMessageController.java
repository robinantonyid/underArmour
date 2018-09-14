package com.underArmour.underArmour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration

@RequestMapping("/")
public class UnderArmourMessageController {

@Autowired
MessageRepository messageRepository;	

 @RequestMapping(value = "/chat",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
 public ResponseEntity<MessageBean> create(@RequestBody MessageBean requestMessageBean) {
		MessageBean messageBean = new MessageBean();
		
		messageBean = messageRepository.createUserMessage(requestMessageBean);
		 
		return new ResponseEntity<MessageBean>(messageBean, HttpStatus.CREATED);
	 
	 }
 
 @RequestMapping(value = "/chat/{id}", method = RequestMethod.GET)
	
 public ResponseEntity<MessageBean> getbyMessageID(@PathVariable Integer id) {
	 MessageBean messageBean = new MessageBean();
		
     messageBean = messageRepository.findUserMessageDataByID(id);
	 
	 return new ResponseEntity<MessageBean>(messageBean, HttpStatus.OK);
 
 }
 
 @RequestMapping(value = "/chat/{username}", method = RequestMethod.GET)
	
 public ResponseEntity<List<MessageBean>> getunexpiredUserMessageDataByUserName(@RequestParam(value="username")String username) {
	 
	 List<MessageBean> messageBeanList = null;
	 messageBeanList = messageRepository.findUnexpiredUserMessageDataByUserName(username);
	 
     return new ResponseEntity<List<MessageBean>>(messageBeanList, HttpStatus.OK);
 
 }

}