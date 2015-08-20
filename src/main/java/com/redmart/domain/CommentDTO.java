package com.redmart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "comment")
public class CommentDTO {

	@Column(name = "comment_id")
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_ticket_id", nullable = false)
	@JsonBackReference
	private TicketDTO comment_ticket;
		
	@Column(name="comment")
	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public TicketDTO getComment_ticket() {
		return comment_ticket;
	}

	public void setComment_ticket(TicketDTO comment_ticket) {
		this.comment_ticket = comment_ticket;
	}	
	
}
