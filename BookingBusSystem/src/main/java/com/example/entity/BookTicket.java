package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_busticket")
public class BookTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idbook_busticket")
	int idbooksticket;

	@ManyToOne
	@JoinColumn(name = "id_users")
	Users users;

	@ManyToOne
	@JoinColumn(name = "id_ticket")
	BusTicket ticket;

	@ManyToOne
	@JoinColumn(name = "idstatus_book")
	StatusBook statusbook;
	
	@Column(name ="cancleday")
	private String cancleday;
	
	@Column (name="bookday")
	private String bookday;

	public BookTicket() {
		super();

	}

	

	



	public BookTicket(int idbooksticket, Users users, BusTicket ticket, StatusBook statusbook, String cancleday,
			String bookday) {
		super();
		this.idbooksticket = idbooksticket;
		this.users = users;
		this.ticket = ticket;
		this.statusbook = statusbook;
		this.cancleday = cancleday;
		this.bookday = bookday;
	}







	public int getIdbooksticket() {
		return idbooksticket;
	}

	public void setIdbooksticket(int idbooksticket) {
		this.idbooksticket = idbooksticket;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public BusTicket getTicket() {
		return ticket;
	}

	public void setTicket(BusTicket ticket) {
		this.ticket = ticket;
	}

	public StatusBook getStatusbook() {
		return statusbook;
	}

	public void setStatusbook(StatusBook statusbook) {
		this.statusbook = statusbook;
	}

	public String getCancleday() {
		return cancleday;
	}

	public void setCancleday(String cancleday) {
		this.cancleday = cancleday;
	}



	public String getBookday() {
		return bookday;
	}



	public void setBookday(String bookday) {
		this.bookday = bookday;
	}

	
	
}
