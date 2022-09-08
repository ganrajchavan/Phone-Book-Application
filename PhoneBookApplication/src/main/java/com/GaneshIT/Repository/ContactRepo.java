package com.GaneshIT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GaneshIT.model.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
