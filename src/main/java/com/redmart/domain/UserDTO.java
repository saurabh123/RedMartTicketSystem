package com.redmart.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employee")
public class UserDTO {

	@Column(name = "employee_id")
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "emailid")
	private String emailId;
	
	@Column(name = "designation")
	private String designation;
	
	@OneToMany (mappedBy="ticket_assignedTo")
	@JsonIgnore
	private Set<TicketDTO> tickets = new HashSet<TicketDTO>();

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Set<TicketDTO> getTickets() {
		return tickets;
	}

	public void setTickets(Set<TicketDTO> tickets) {
		this.tickets = tickets;
	}	
	
}
