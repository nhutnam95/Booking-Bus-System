package com.example.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.BusTicket;

public interface BusTicketRepository extends JpaRepository<BusTicket, Integer> {

	@Query("Select t from BusTicket t where t.bus.idbus = :idbus and t.scheduleday= :scheduleday")
	List<BusTicket> findByIdbusAndScheduleday(@Param("idbus") int idbus, @Param("scheduleday") Date scheduleday);
	
	@Query("SELECT t FROM BusTicket t WHERE t.bus.idbus = :idbus AND t.scheduleday= :scheduleday")
	Page<BusTicket> findByIdbusAndScheduleday(@Param("idbus") int idbus, @Param("scheduleday") Date scheduleday, Pageable pageable);

	@Query("SELECT t FROM BusTicket t WHERE t.bus.idbus = :idbus AND t.scheduleday= :scheduleday AND t.status.idstatus = :idstatus")
	Page<BusTicket> findByIdbusAndScheduledayAndIdstatus(@Param("idbus") int idbus,
			@Param("scheduleday") Date scheduleday, @Param("idstatus") int idstatus, Pageable pageable);
	
	@Modifying
	@Query("update BusTicket t set t.status.idstatus = 2 where t.idticket = :idticket ")
	void updateSeatBook(@Param("idticket")int id);
	
	@Modifying
	@Query("UPDATE BusTicket t SET t.status.idstatus = 1 WHERE t.idticket = :idticket")
	void updateAvailableTicket(@Param("idticket") int id);
	
}
