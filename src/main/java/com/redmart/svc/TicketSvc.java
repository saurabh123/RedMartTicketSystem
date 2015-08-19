package com.redmart.svc;

import java.util.ArrayList;

import com.redmart.domain.TicketDTO;
import com.redmart.domain.UserDTO;

public interface TicketSvc {
	
public String createTicket(TicketDTO ticket) throws Exception;
public ArrayList<TicketDTO> getTickets();
public TicketDTO  viewTicket(int ticketId);
public String updateTicket(int status,String username,int ticketId);
public String addComment(String comment, int ticketId);
public ArrayList<UserDTO> listEmployee();

}
