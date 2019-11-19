package com.example.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer>{
		
		
//		@Query("Select DISTINCT b from Bus b join b.busticket s where b.route.idroute =:idroute and  s.scheduleday = :date ")
//		List<Bus>findBuss(@Param("idroute") int idroute , @Param("date") Date date);
//
//		@Query("Select b ,count(s) as countSeat  from Bus b join b.busticket s where b.idbus = :id  and s.status.idstatus = 1 and s.scheduleday = :scheduleday ")
//		List<Bus>findByID(@Param("id") int id,@Param("scheduleday") Date scheduleday);
		
		//find Bus
		@Query("Select b,count(s) as countSeat,b.route.place  from Bus b join b.busticket s where b.route.idroute =:idroute and  s.scheduleday = :date and s.status.idstatus = 1 group by b.idbus")
		List<Bus>findBuss(@Param("idroute") int idroute , @Param("date") Date date);
		
	
		
		
}
