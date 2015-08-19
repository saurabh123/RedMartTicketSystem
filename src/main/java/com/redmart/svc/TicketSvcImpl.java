package com.redmart.svc;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redmart.dao.TicketDAO;
import com.redmart.domain.TicketDTO;
import com.redmart.domain.UserDTO;

@Service
public class TicketSvcImpl implements TicketSvc {

	@Autowired
	private TicketDAO ticketDAO;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = false, rollbackFor=Exception.class)
	public String createTicket(TicketDTO ticket) throws Exception {
		// TODO Auto-generated method stub
		
		try{
			ticket.setTicket_createdon(new Date());
			ticketDAO.createTicket(ticket);
			return "success";
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception();
		}
		
	}

	@Transactional(readOnly = true, rollbackFor=Exception.class)
	public ArrayList<TicketDTO> getTickets() {
		  return ticketDAO.getTickets();
	}

	@Transactional(readOnly = true, rollbackFor=Exception.class)
	public TicketDTO viewTicket(int ticketId) {
		return ticketDAO.viewTicket(ticketId);
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class)
	public String updateTicket(int status, String username,int ticketId) {
		return ticketDAO.updateTicket(status,username,ticketId);
		
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class)
	public String addComment(String comment, int ticketId) {
		return ticketDAO.addComment(comment,ticketId);
	}

	@Transactional(readOnly = true, rollbackFor=Exception.class)
	public ArrayList<UserDTO> listEmployee() {
		// TODO Auto-generated method stub
		return ticketDAO.listEmployee();
	}

	

		
	
}
