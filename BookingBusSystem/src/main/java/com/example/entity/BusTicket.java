package com.example.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bus_ticket")
public class BusTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ticket", nullable = false)
	private int idticket;

	@Column(name = "name_seat")
	private String nameseat;

	@ManyToOne
	@JoinColumn(name = "id_status")
	private StatusSeat status;

	@Column(name = "schedule_day")
	private Date scheduleday;

	@ManyToOne
	@JoinColumn(name = "id_bus")
	private Bus bus;

	public BusTicket() {
		super();
	}

	public BusTicket(int idticket, String nameseat, StatusSeat status, Date scheduleday, Bus bus) {
		super();
		this.idticket = idticket;
		this.nameseat = nameseat;
		this.status = status;
		this.scheduleday = scheduleday;
		this.bus = bus;
	}

	public int getIdticket() {
		return idticket;
	}

	public void setIdticket(int idticket) {
		this.idticket = idticket;
	}

	public String getNameseat() {
		return nameseat;
	}

	public void setNameseat(String nameseat) {
		this.nameseat = nameseat;
	}

	public StatusSeat getStatus() {
		return status;
	}

	public void setStatus(StatusSeat status) {
		this.status = status;
	}

	public Date getScheduleday() {
		return scheduleday;
	}

	public void setScheduleday(Date scheduleday) {
		this.scheduleday = scheduleday;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

}
