package com.example.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.BookTicket;
import com.example.entity.Bus;
import com.example.entity.BusTicket;
import com.example.entity.Route;

public interface BusService {

	List<Bus> getBuses();

	List<Bus> findBuss(int idroute, Date date);

	List<BusTicket> findByIdbusAndScheduleday(int idticket, Date scheduleday);

	List<Route> findAll();

	BookTicket save(BookTicket bookticket);

	List<Route> FindRouteAndService();

	void updateSeatBook(int idticket);
	
	Page<BookTicket>findTicketbyUser(int iduser,Pageable pageable);
	
	void updateStatusBookTicket(int idbooksticket,String cancleday);

}
