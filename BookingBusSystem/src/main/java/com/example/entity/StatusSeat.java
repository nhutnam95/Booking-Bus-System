package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class StatusSeat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_status", nullable = false)
	private int idstatus;

	@Column(name = "status")
	private String status;

	public StatusSeat() {
		super();
	}

	public StatusSeat(int idstatus, String status) {
		super();
		this.idstatus = idstatus;
		this.status = status;
	}

	public int getIdstatus() {
		return idstatus;
	}

	public void setIdstatus(int idstatus) {
		this.idstatus = idstatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
