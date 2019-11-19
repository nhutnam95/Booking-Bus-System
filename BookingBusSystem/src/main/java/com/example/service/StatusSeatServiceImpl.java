package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.StatusSeat;
import com.example.repository.StatusSeatRepository;

@Service
public class StatusSeatServiceImpl implements StatusSeatService {
	
	@Autowired
	private StatusSeatRepository statusRepository;

	@Override
	public List<StatusSeat> getStatusList() {
		return statusRepository.findAll();
	}

}
