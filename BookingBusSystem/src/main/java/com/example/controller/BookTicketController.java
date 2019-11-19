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

import com.example.entity.BookTicket;
import com.example.repository.BookTicketRepository;
import com.example.service.BookTicketService;
import com.example.service.BusTicketService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/book-ticket")
public class BookTicketController {
	
	@Autowired
	private BookTicketService bookTicketService;
	
	
	@Autowired
	private BusTicketService busTicketService;
	
	@Autowired
	private BookTicketRepository bookTicketRepository;
	
	@GetMapping("/all")
	public List<BookTicket> getAllBookTickets() {
		return bookTicketService.getAllBookTickets();
	}
	
	@GetMapping("/pages")
	public Page<BookTicket> getAllBookTicket(@RequestParam(defaultValue="0") int page) {
		return bookTicketService.getBookTickets(PageRequest.of(page, 10));
	}
	
	@GetMapping("/get/{id}")
	public Optional<BookTicket> getBookTicketById(@PathVariable int id) {
		return bookTicketService.getBookTicketById(id);
	}
	
	@GetMapping("/get/ticket/{id}")
	public Optional<BookTicket> getBookTicketByIdTicket(@PathVariable int idTicket) {
		return bookTicketService.getBookTicketByIdTicket(idTicket);
	}
	
	@PutMapping("/update-status")
	public void updateStatus(@RequestParam("id") int id, @RequestBody BookTicket bookTicket) {
		bookTicketService.updateStatusBookTicket(id);
		
		Optional<BookTicket> b = bookTicketService.getBookTicketById(id);
		BookTicket bookedTicket = b.get();
		
		int ticketId=bookedTicket.getTicket().getIdticket();
		
		busTicketService.updateAvailableTicket(ticketId);
	}
	@GetMapping("/get-by-id")
	public Page<BookTicket> getByIdBusAndScheduleDay(@RequestParam("idbus") int idBus, @RequestParam("scheduleday") String scheduleDay, @RequestParam(defaultValue="0") int page) {
		return bookTicketService.getByIdBusAndScheduleDay(idBus, Date.valueOf(scheduleDay), PageRequest.of(page, 10));
	}
	
	
	@GetMapping("/statusfilter")
	public List<BookTicket> statusfilter(@RequestParam("idstatus") int idstatus){
		return bookTicketRepository.findByStatusbook_Idstatusbook(idstatus) ;
		
	}
	
	@GetMapping("/routefilter")
	public List<BookTicket> routefilter(@RequestParam("place") String place){
		return bookTicketRepository.findByRoute(place);
	}
	
	@GetMapping("/routerandstatusfilter")
	public List<BookTicket> statusandroutefilter(@RequestParam("place") String place,@RequestParam("idstatus") int idstatus){
		return bookTicketRepository.findByRouteandStatus(place,idstatus);
	}
	
	
	
}
