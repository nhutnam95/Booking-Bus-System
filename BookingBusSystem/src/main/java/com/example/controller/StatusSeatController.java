package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.StatusSeat;
import com.example.service.StatusSeatService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class StatusSeatController {
	
	@Autowired
	private StatusSeatService statusService;
	
	@GetMapping("/status-seat-list")
	public List<StatusSeat> getStatusList() {
		return statusService.getStatusList();
	}

}
