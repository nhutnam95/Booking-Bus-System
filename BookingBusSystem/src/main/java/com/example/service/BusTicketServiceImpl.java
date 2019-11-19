package com.example.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.BusTicket;
import com.example.repository.BusTicketRepository;

@Service
public class BusTicketServiceImpl implements BusTicketService {

	@Autowired
	private BusTicketRepository ticketRepository;

	@Override
	public List<BusTicket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Page<BusTicket> getAllTickets(Pageable pageable) {
		return ticketRepository.findAll(pageable);
	}

	@Override
	public Optional<BusTicket> getTicket(int id) {
		return ticketRepository.findById(id);
	}

	@Override
	public BusTicket findTicket(int id) {
		return ticketRepository.getOne(id);
	}

	@Transactional
	@Override
	public void save(BusTicket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public Page<BusTicket> findByIdbusAndScheduleday(int idbus, Date scheduleday, Pageable pageable) {
		return ticketRepository.findByIdbusAndScheduleday(idbus, scheduleday, pageable);
	}

	@Override
	public Page<BusTicket> findByIdbusAndScheduledayAndIdstatus(int idbus, Date scheduleday, int idstatus,
			Pageable pageable) {
		return ticketRepository.findByIdbusAndScheduledayAndIdstatus(idbus, scheduleday, idstatus, pageable);
	}

	@Transactional
	@Override
	public void updateAvailableTicket(int id) {
		ticketRepository.updateAvailableTicket(id);
	}

}
