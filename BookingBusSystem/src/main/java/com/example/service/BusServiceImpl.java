package com.example.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.BookTicket;
import com.example.entity.Bus;
import com.example.entity.BusTicket;
import com.example.entity.Route;
import com.example.repository.BookTicketRepository;
import com.example.repository.BusRepository;
import com.example.repository.BusTicketRepository;
import com.example.repository.RouteRepository;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	BusRepository busRepository;

	@Autowired
	BusTicketRepository busticketRepository;

	@Override
	public List<Bus> getBuses() {
		return busRepository.findAll();
	}

	@Autowired
	RouteRepository routeRepository;

	@Autowired
	BookTicketRepository bookticketRepository;

	@Override
	public List<Bus> findBuss(int idroute, Date date) {

		return busRepository.findBuss(idroute, date);
	}

	public List<BusTicket> findByIdbusAndScheduleday(int idticket, Date scheduleday) {

		return busticketRepository.findByIdbusAndScheduleday(idticket, scheduleday);
	}

	public List<Route> findAll() {

		return routeRepository.findAll();
	}

	@Override
	public BookTicket save(BookTicket bookticket) {

		return bookticketRepository.save(bookticket);
	}

	@Override
	public List<Route> FindRouteAndService() {

		return routeRepository.allRouteandBus();
	}

	@Override
	@Transactional
	public void updateSeatBook(int idticket) {
		busticketRepository.updateSeatBook(idticket);

	}


	@Override
	public Page<BookTicket> findTicketbyUser(int iduser,Pageable pageable) {
		
		return bookticketRepository.findTicketByUser(iduser,pageable);
	}


	@Override
	@Transactional
	public void updateStatusBookTicket(int idbooksticket,String cancleday) {
		bookticketRepository.updateStatusBookTicket(idbooksticket,cancleday);
		
	}


	

}
