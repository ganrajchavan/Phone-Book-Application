package com.GaneshIT.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GaneshIT.model.Contact;
import com.GaneshIT.service.ContactServiceI;
import com.GaneshIT.util.AppConstant;
import com.GaneshIT.util.AppProps;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceI contactServiceI;
	
	@Autowired
	private AppProps appProps;
	
	@PostMapping(value = "/saveContact")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
		boolean saveContact = contactServiceI.saveContact(contact);
		Map<String, String> message = appProps.getMessage();
		
		if(saveContact ==true) {
			
			String msg=message.get(AppConstant.SAVE_SUCCESS);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg=message.get(AppConstant.SAVE_FAIL);
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		
		}
	}
	@GetMapping(value = "/getAllContact",produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContact(){
		List<Contact> allContact = contactServiceI.getAllContact();
		if(allContact !=null) {
			return new ResponseEntity<List<Contact>>(allContact,HttpStatus.OK);
		}else {
			String msg="Data not found";
		return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
		
		}	
	}
	@GetMapping(value = "/getContactById/{cid}",produces = "application/json")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer cid){
		Contact contactById = contactServiceI.getContactById(cid);
		return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
		
	}	
	
	@PutMapping(value = "/updateContact",consumes = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact){
		boolean saveContact = contactServiceI.updateContact(contact);
		Map<String, String> message = appProps.getMessage();
		
		if(saveContact ==true) {
			String msg=message.get(AppConstant.UPDATE_SUCCESS);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			String msg=message.get(AppConstant.UPDATE_FAIL);
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		
		}
	}
	
	@DeleteMapping(value = "/deleteContactById/{cid}")
	public ResponseEntity<String> deleteContactById(@PathVariable Integer cid){
		
		boolean deleteById = contactServiceI.deleteById(cid);
		Map<String, String> message = appProps.getMessage();
		
		
		if(deleteById) {
			
			return new ResponseEntity<String>(message.get(AppConstant.DELETE_SUCCESS),HttpStatus.OK);
		}else {
		
			return new ResponseEntity<String>(message.get(AppConstant.DELETE_FAIL),HttpStatus.BAD_REQUEST);
			
		
		}
	}
	
	
	
	
	
	
	
}
