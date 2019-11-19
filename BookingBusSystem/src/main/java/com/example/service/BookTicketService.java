package com.example.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.BookTicket;

public interface BookTicketService {
	
	List<BookTicket> getAllBookTickets();
	
	Page<BookTicket> getBookTickets(Pageable pagable);
	
	Optional<BookTicket> getBookTicketByIdTicket(int idTicket);
	
	Optional<BookTicket> getBookTicketById(int id);
	
	void save(BookTicket bookTicket);
	
	void updateStatusBookTicket(int id);
	
	Page<BookTicket> getByIdBusAndScheduleDay(int idBus, Date scheduleDay, Pageable pageable);

}
