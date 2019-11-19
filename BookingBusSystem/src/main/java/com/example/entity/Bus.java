package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_bus", nullable = false)
	private int idbus;

	@Column(name = "driver")
	private String driver;

	@Column(name = "license")
	private String license;

	@ManyToOne
	@JoinColumn(name = "idRoute")
	private Route route;

	@Column(name = "image")
	private String image;

	@Column(name = "departure")
	private String departure;

	@Column(name = "arrival")
	private String arrival;

	@Column(name = "start_time")
	private String starttime;

	public Bus() {
		super();
	}

	@OneToMany(mappedBy = "bus")
	private List<BusTicket> busticket;

	public Bus(int idbus, String driver, String license, Route route, String image, String departure, String arrival,
			String starttime) {
		super();
		this.idbus = idbus;
		this.driver = driver;
		this.license = license;
		this.route = route;
		this.image = image;
		this.departure = departure;
		this.arrival = arrival;
		this.starttime = starttime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getIdbus() {
		return idbus;
	}

	public void setIdbus(int idbus) {
		this.idbus = idbus;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

}
