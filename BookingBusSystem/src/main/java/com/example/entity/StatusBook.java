package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status_book")

public class StatusBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idstatus_book")
	int idstatusbook;

	@Column(name = "status_book")
	String statusbook;

	public StatusBook() {
		super();
	}

	public StatusBook(int idstatusbook, String statusbook) {
		super();
		this.idstatusbook = idstatusbook;
		this.statusbook = statusbook;
	}

	public int getIdstatusbook() {
		return idstatusbook;
	}

	public void setIdstatusbook(int idstatusbook) {
		this.idstatusbook = idstatusbook;
	}

	public String getStatusbook() {
		return statusbook;
	}

	public void setStatusbook(String statusbook) {
		this.statusbook = statusbook;
	}

}
