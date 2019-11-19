package com.example.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.BusTicket;
import com.example.entity.StatusSeat;
import com.example.service.BookTicketService;
import com.example.service.BusTicketService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bus-ticket")
public class BusTicketController {

	@Autowired
	private BusTicketService ticketService;
	
	@Autowired
	private BookTicketService bookTicketService;
	
	@GetMapping("/all-tickets")
	public List<BusTicket> getAllTickets() {
		return ticketService.getAllTickets();
	}

	@GetMapping("/tickets")
	public Page<BusTicket> getAllTickets(@RequestParam(defaultValue="0") int page) {
		return ticketService.getAllTickets(PageRequest.of(page, 10));
	}

	@GetMapping("/get/{id}")
	public Optional<BusTicket> getTicket(@PathVariable int id) {
		return ticketService.getTicket(id);
	}

	@PutMapping("/update/{id}")
	public void updateStatusTicket(@PathVariable int id, @RequestBody BusTicket ticket) {
		Optional<BusTicket> busTicket = ticketService.getTicket(id);

		if (busTicket.isPresent()) {
			BusTicket bticket = busTicket.get();

			StatusSeat status = new StatusSeat();
			status.setIdstatus(ticket.getStatus().getIdstatus());

			bticket.setStatus(status);

			ticketService.save(bticket);
			
			bookTicketService.updateStatusBookTicket(bticket.getIdticket());
		}

	}

	@GetMapping("/find-ticket")
	public Page<BusTicket> findByIdbusAndScheduleday(@RequestParam("idbus") int idbus,
			@RequestParam("scheduleday") String scheduleday, @RequestParam(defaultValue = "0") int page) {
		
		return ticketService.findByIdbusAndScheduleday(idbus, Date.valueOf(scheduleday), PageRequest.of(page, 10));
	}

	@GetMapping("/find-status-ticket")
	public Page<BusTicket> findByIdBusAndScheduleDayAndIdStatus(@RequestParam("idbus") int idbus,
			@RequestParam("scheduleday") String scheduleday, @RequestParam("idstatus") int idstatus,
			@RequestParam(defaultValue = "0") int page) {
		
		return ticketService.findByIdbusAndScheduledayAndIdstatus(idbus, Date.valueOf(scheduleday), idstatus,
				PageRequest.of(page, 10));
	}

}
