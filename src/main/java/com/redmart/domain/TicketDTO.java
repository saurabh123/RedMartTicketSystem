package com.redmart.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ticket")
public class TicketDTO {
	

	@Column(name = "ticket_id")
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;
	

	@Column(name="ticket_area")
	private String area;
	
	@Column(name="ticket_description")
	private String description;
	
	@OneToOne (mappedBy="ticket",fetch = FetchType.EAGER)
	private CustomerDTO customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_ticketstatus_code", nullable = false)
    private TicketStatusDTO ticket_status;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ticket_createdon")
    private Date ticket_createdon;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_ticket_assignedTo", nullable = true)
    private UserDTO ticket_assignedTo;
	
	@OneToMany (mappedBy="ticket",fetch = FetchType.EAGER)
	private Set<CommentDTO> pr_tags = new HashSet<CommentDTO>();

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public TicketStatusDTO getTicket_status() {
		return ticket_status;
	}

	public void setTicket_status(TicketStatusDTO ticket_status) {
		this.ticket_status = ticket_status;
	}

	public Date getTicket_createdon() {
		return ticket_createdon;
	}

	public void setTicket_createdon(Date ticket_createdon) {
		this.ticket_createdon = ticket_createdon;
	}

	public UserDTO getTicket_assignedTo() {
		return ticket_assignedTo;
	}

	public void setTicket_assignedTo(UserDTO ticket_assignedTo) {
		this.ticket_assignedTo = ticket_assignedTo;
	}

	public Set<CommentDTO> getPr_tags() {
		return pr_tags;
	}

	public void setPr_tags(Set<CommentDTO> pr_tags) {
		this.pr_tags = pr_tags;
	}

			

}
