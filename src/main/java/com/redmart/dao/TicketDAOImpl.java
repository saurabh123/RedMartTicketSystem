package com.redmart.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.redmart.domain.CommentDTO;
import com.redmart.domain.CustomerDTO;
import com.redmart.domain.TicketDTO;
import com.redmart.domain.TicketStatusDTO;
import com.redmart.domain.UserDTO;

@Repository
public class TicketDAOImpl implements TicketDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void createTicket(TicketDTO ticket) {

		Session session = this.sessionFactory.getCurrentSession();
		
		TicketStatusDTO ticket_status = (TicketStatusDTO) session.load(TicketStatusDTO.class, 1);
		ticket.setTicket_status(ticket_status);
		CustomerDTO customer = new CustomerDTO();
		customer=ticket.getCustomer();
		customer.setTicket(ticket);
		
		session.save(ticket);
		session.save(customer);
	}

	public ArrayList<TicketDTO> getTickets() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		List tickets = session.createCriteria(TicketDTO.class).list();
	    ArrayList<TicketDTO> ticketlist = new ArrayList<TicketDTO>(tickets);		
		return ticketlist;	
		
	}

	public TicketDTO viewTicket(int ticketId) {
	
		Session session = this.sessionFactory.getCurrentSession();
		TicketDTO ticket = (TicketDTO)session.get(TicketDTO.class,ticketId);		
		return ticket;
	}

	public String updateTicket(int status, String username,int ticketId) {
		Session session = this.sessionFactory.getCurrentSession();
		TicketDTO ticket = (TicketDTO)session.load(TicketDTO.class,ticketId);
		StringBuffer response = new StringBuffer();
		if(status!=0)
		{
			TicketStatusDTO ticket_status = (TicketStatusDTO)session.get(TicketStatusDTO.class,status);
			ticket.setTicket_status(ticket_status);
			response.append("Ticket Status Updated");
		}
		if(!username.equalsIgnoreCase("0"))
		{
			UserDTO user =  (UserDTO) session.createCriteria(UserDTO.class).add(Restrictions.eq("name",username)).uniqueResult();			
			ticket.setTicket_assignedTo(user);
			response.append("|Ticket Assigned to "+user.getName());
		}
		
		session.saveOrUpdate(ticket);
		
		return response.toString();
	}

	public String addComment(String comment, int ticketId) {
		
		Session session = this.sessionFactory.getCurrentSession();
		TicketDTO ticket = (TicketDTO)session.load(TicketDTO.class,ticketId);
		CommentDTO commentdto = new CommentDTO();
		commentdto.setComment(comment);
		commentdto.setComment_ticket(ticket);
		session.save(commentdto);
		return "Comment Successfully Updated";
		 

	}

	public ArrayList<UserDTO> listEmployee() {
		Session session = this.sessionFactory.getCurrentSession();

		Collection employee = new LinkedHashSet(session.createCriteria(UserDTO.class).list());
	    ArrayList<UserDTO> employelist = new ArrayList<UserDTO>(employee);
			return employelist;
	}


}
