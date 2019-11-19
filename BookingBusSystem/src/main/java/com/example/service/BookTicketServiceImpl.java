package com.example.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.BookTicket;
import com.example.repository.BookTicketRepository;

@Service
public class BookTicketServiceImpl implements BookTicketService {
	
	@Autowired
	private BookTicketRepository bookTicketRepository;

	@Override
	public List<BookTicket> getAllBookTickets() {
		return bookTicketRepository.findAll();
	}

	@Override
	public Page<BookTicket> getBookTickets(Pageable pagable) {
		return bookTicketRepository.findAll(pagable);
	}

	@Override
	public Optional<BookTicket> getBookTicketByIdTicket(int idTicket) {
		return bookTicketRepository.getBookTicket(idTicket);
	}
	
	@Override
	public Optional<BookTicket> getBookTicketById(int id) {
		return bookTicketRepository.findById(id);
	}

	@Transactional
	@Override
	public void save(BookTicket bookTicket) {
		bookTicketRepository.save(bookTicket);
	}

	@Transactional
	@Override
	public void updateStatusBookTicket(int id) {
		bookTicketRepository.updateStatus(id);
	}

	@Override
	public Page<BookTicket> getByIdBusAndScheduleDay(int idBus, Date scheduleDay, Pageable pageable) {
		return bookTicketRepository.findByIdBusAndScheduleDay(idBus, scheduleDay, pageable);
	}

}
