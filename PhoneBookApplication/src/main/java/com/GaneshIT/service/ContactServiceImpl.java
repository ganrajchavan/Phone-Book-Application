package com.GaneshIT.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GaneshIT.Repository.ContactRepo;
import com.GaneshIT.model.Contact;

@Service
public class ContactServiceImpl implements ContactServiceI{

	@Autowired
	private ContactRepo contactRepo;
	@Override
	public boolean saveContact(Contact contact) {
		Contact save = contactRepo.save(contact);
		if(save!=null) {
			return true;
		}else {
		
		return false;
	}
	}
	@Override
	public List<Contact> getAllContact() {
		List<Contact> contacts = contactRepo.findAll();
		Stream<Contact> stream = contacts.stream();
		Stream<Contact> filter = stream.filter(contact -> contact.getActiveSwitch()=='y');
				List<Contact> collect = filter.collect(Collectors.toList());
		
		return collect;
	}
	@Override
	public Contact getContactById(Integer cid) {
		Contact findById = contactRepo.findById(cid).get();
		return findById;
	}
	@Override
	public boolean updateContact(Contact contact) {
		Contact save = contactRepo.save(contact);
		
		if(save==null) {
			return false;
		}else {
		return true;
	}
		}
	@Override
	public boolean deleteById(Integer cid) {
		
		
//		boolean existsById = contactRepo.existsById(cid);
//		if(existsById) {
//			contactRepo.deleteById(cid);
//			return true;
//		}else {
//		
//		return false;
//		}
		
//		Optional<Contact> findById = contactRepo.findById(cid);
//		if(findById.isPresent()) {
//			
//			contactRepo.deleteById(cid);
//			return true;
//		}
//		return false;
//		
//	}
	
	Optional<Contact> contact = contactRepo.findById(cid);
	if(contact.isPresent()) {
		Contact contact2 = contact.get();
		contact2.setActiveSwitch('N');
		contactRepo.save(contact2);
		return true;
	}else {
		return false;
	}
	}	
	

}