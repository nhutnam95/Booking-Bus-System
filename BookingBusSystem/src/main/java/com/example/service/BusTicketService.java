package com.example.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.BusTicket;

public interface BusTicketService {
	
	List<BusTicket> getAllTickets();

	Page<BusTicket> getAllTickets(Pageable pageable);

	Optional<BusTicket> getTicket(int id);

	BusTicket findTicket(int id);

	void save(BusTicket ticket);
	
	Page<BusTicket> findByIdbusAndScheduleday(int idbus, Date scheduleday, Pageable pageable);
	
	Page<BusTicket> findByIdbusAndScheduledayAndIdstatus(int idbus, Date scheduleday, int idstatus, Pageable pageable);
	
	void updateAvailableTicket(int id);

}
