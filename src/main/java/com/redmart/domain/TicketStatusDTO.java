package com.redmart.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "ticket_status")
public class TicketStatusDTO {
	
	@Column(name="status_code")
	@Id
	private int status_code;
	
	@Column(name="status_value")
	private String status_value;
	
	
	public int getStatus_code() {
		return status_code;
	}

	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}

	public String getStatus_value() {
		return status_value;
	}

	public void setStatus_value(String status_value) {
		this.status_value = status_value;
	}

	
	
	

}
