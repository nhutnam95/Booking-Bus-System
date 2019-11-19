package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {
		
	@Query("Select r,count(b) from Route r join r.bus b group by r.idroute ")
	List<Route>allRouteandBus();
}
