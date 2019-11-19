package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idRoute", nullable = false)
	private int idroute;

	@Column(name = "place")
	private String place;

	@Column(name = "price")
	private int price;
	
	@OneToMany(mappedBy = "route")
	private List<Bus> bus;

	public Route() {
		super();
	}

	public Route(int idroute, String place, int price) {
		super();
		this.idroute = idroute;
		this.place = place;
		this.price = price;
	}

	public int getIdroute() {
		return idroute;
	}

	public void setIdroute(int idroute) {
		this.idroute = idroute;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
