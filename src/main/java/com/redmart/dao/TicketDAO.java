package com.redmart.dao;

import java.util.ArrayList;

import com.redmart.domain.TicketDTO;
import com.redmart.domain.UserDTO;

public interface TicketDAO {

	void createTicket(TicketDTO ticket);
	ArrayList<TicketDTO> getTickets();
	TicketDTO viewTicket(int ticketId);
	String updateTicket(int status, String username,int ticketId);
	String addComment(String comment,int ticketId);
	ArrayList<UserDTO> listEmployee();
	
}
