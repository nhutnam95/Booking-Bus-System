package com.example.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.BookTicket;
import com.example.entity.Bus;
import com.example.entity.BusTicket;
import com.example.entity.Route;
import com.example.service.BusService;
import com.example.service.BusTicketService;

@CrossOrigin("*")
@RestController
public class BusController {
	@Autowired
	BusService busService;
	
	@Autowired
	private BusTicketService ticketService;

	/*@GetMapping("/bus")
	public List<Bus> availableBus() {
		return busService.findBySeat();
	}*/

	@GetMapping("/buses")
	public List<Bus> getBuses() {
		return busService.getBuses();
	}

	@GetMapping("/findbus")
	public List<Bus> findBus(@RequestParam("idRoute") int idRoute, @RequestParam("date") String date) {
		return busService.findBuss(idRoute, Date.valueOf(date));
	}


//	@GetMapping("/detail")
//	public List<Bus> detail(@RequestParam("id") int id,@RequestParam("scheduleday") String scheduleday){
//		return busService.findByID(id,Date.valueOf(scheduleday));
//	}


	@GetMapping("/seat")
	public List<BusTicket> findAllSeat(@RequestParam("idbus") int idbus,
			@RequestParam("scheduleday") String scheduleday) {
		return busService.findByIdbusAndScheduleday(idbus, Date.valueOf(scheduleday));

	}

	
	@GetMapping("/route")
	public List<Route> AllRoute (){
		return busService.findAll();
		
	}
	
	@PostMapping("/bookticket")
	public BookTicket bookticket (@RequestBody BookTicket bookticket,@RequestParam("idticket") int idticket) {
		busService.updateSeatBook(idticket);
		return busService.save(bookticket);
		
	}
	
	@GetMapping("/routeandbus")
	public List<Route> RouteandBus(){
		return busService.FindRouteAndService();
	}
	
	
	@GetMapping("/ticketusers")
	public Page<BookTicket> findTicketbyUsers(@RequestParam("iduser") int iduser,@RequestParam(defaultValue = "0") int page)
	{
		return busService.findTicketbyUser(iduser,PageRequest.of(page,4));
	}
	
	@GetMapping("/cancleticket")
	public void cancleticket (@RequestParam("idbookticket") int idbookticket,@RequestParam("cancleday") String cancleday,@RequestParam("idbusticket") int idbusticket)
	{
		ticketService.updateAvailableTicket(idbusticket);
		busService.updateStatusBookTicket(idbookticket,cancleday);
	}
}     



    



