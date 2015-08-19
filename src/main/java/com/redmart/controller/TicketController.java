package com.redmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.redmart.domain.TicketDTO;
import com.redmart.domain.UserDTO;
import com.redmart.svc.TicketSvc;

@Controller
public class TicketController {

	
	@Autowired
	private TicketSvc ticketsvc;
	
	

	@RequestMapping(value = "/newticket", method = RequestMethod.GET)
	public String newTicket(Model model,@RequestParam(required=false,value="showMessage",defaultValue="false") String showMessage) {

		if(showMessage.equalsIgnoreCase("true"))
			model.addAttribute("showMessage", "true");
		else
			model.addAttribute("showMessage", "false");
		
		return "ticket/ticket";

	} 	
	
	//To Create a New Ticket
	@RequestMapping(value = {"/createticket"}, method = RequestMethod.POST, produces={"application/json"})
	public @ResponseBody String createTicket(@RequestBody TicketDTO ticket) 
	{
			
			try{
				ticketsvc.createTicket(ticket);
				return "success";
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return "failure";
			}
		
	}
	
	@RequestMapping(value = "/listticket", method = RequestMethod.GET)
	public String listTicket(Model model) {
		return "ticket/ticketlist";

	} 
	
	//To View List of all ticket
	 @ResponseStatus(HttpStatus.OK)
		@RequestMapping(value = {"/tickets"}, method = RequestMethod.GET, produces={"application/json"})
		public @ResponseBody List<TicketDTO> getTickets(Model model, @RequestParam(required=false,value="status",defaultValue="1") Integer status) {
		    return ticketsvc.getTickets();
		 
	 }
	 
	 @RequestMapping(value = "/editticket", method = RequestMethod.POST)
		public ModelAndView  editTicket( @RequestParam("ticketid") int ticketid)
		{
		 	
			ModelAndView mav = new ModelAndView("ticket/editticket");
			mav.addObject("ticketid",ticketid);
			return mav;
		 
		}
	 
	 @RequestMapping(value = " /ticket/{ticketId}", method=RequestMethod.GET, produces={"application/json"})
	 public @ResponseBody TicketDTO viewTicket(@PathVariable int ticketId){
		 return ticketsvc.viewTicket(ticketId);
	 } 
	 
	 @RequestMapping(value = " /ticket/update/{ticketId}", method=RequestMethod.POST, produces={"application/json"})
	 public @ResponseBody String updateTicket(@RequestParam(required=false,value="status",defaultValue="0") int status,@RequestParam(required=false,value="assignto",defaultValue="0") String assignto
			 ,@PathVariable int ticketId){
		 return ticketsvc.updateTicket(status,assignto,ticketId);
	 }
	 
	 @RequestMapping(value = " /ticket/comment/{ticketId}", method=RequestMethod.POST, produces={"application/json"})
	 public @ResponseBody String postComment(@RequestParam("comment") String comment,@PathVariable int ticketId)
		{
        	return	 ticketsvc.addComment(comment,ticketId);
		 
	   }
	 	 
		@RequestMapping(value = {"/getemployee"}, method = RequestMethod.GET, produces={"application/json"})
		public @ResponseBody List<UserDTO> getEmployee(Model model)
		{
		    return ticketsvc.listEmployee();
		} 
	}
