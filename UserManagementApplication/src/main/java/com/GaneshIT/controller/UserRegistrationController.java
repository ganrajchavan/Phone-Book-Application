package com.GaneshIT.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GaneshIT.binding.UserForm;
import com.GaneshIT.service.UserServiceI;

@RestController
public class UserRegistrationController {

	@Autowired
	private UserServiceI userServiceI;

	@GetMapping("/countries")
	public Map<Integer, String> countries() {
		Map<Integer, String> countries = userServiceI.getCountries();

		return countries;

	}
	
	@GetMapping("/states/{countryId}")
	public Map<Integer, String> states(@PathVariable Integer countryId) {
		Map<Integer, String> states = userServiceI.getStates(countryId);
		return states;

	}
	
	@GetMapping("/cities/{stateId}")
	public Map<Integer, String> cities(@PathVariable Integer stateId) {
		Map<Integer, String> cities = userServiceI.getCities(stateId);

		return cities;

	}
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody UserForm userForm) {
	
		boolean saveUser = userServiceI.saveUser(userForm);
		
		if(saveUser) {
			return "User Saved Successfully.Check your mail for Unlock account";
		}
		return "User Not saved Successfully";
		
	}
	
}
