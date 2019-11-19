package com.example.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.BookTicket;

public interface BookTicketRepository extends JpaRepository<BookTicket, Integer> {
	
	@Query("Select b from BookTicket b where b.users.id = :iduser and b.statusbook.idstatusbook = 1 ")
	Page<BookTicket>findTicketByUser(@Param("iduser") int iduser,Pageable pageable);
	
	@Modifying
	@Query("update BookTicket b set b.statusbook.idstatusbook = 2,b.cancleday=:cancleday where b.idbooksticket = :idbooksticket ")
	void updateStatusBookTicket(@Param("idbooksticket")int id,@Param("cancleday") String cancleday );
	
	@Query("SELECT b FROM BookTicket b WHERE b.ticket.idticket = :idticket")
	Optional<BookTicket> getBookTicket(@Param("idticket") int idticket);
	
	@Modifying
	@Query("UPDATE BookTicket b SET b.statusbook.idstatusbook = 2 WHERE b.idbooksticket = :id")
	void updateStatus(@Param("id") int id); 
	@Query("SELECT b FROM BookTicket b WHERE b.ticket.bus.idbus = :idbus AND b.ticket.scheduleday = :scheduleday")
	Page<BookTicket> findByIdBusAndScheduleDay(@Param("idbus") int idBus, @Param("scheduleday") Date scheduleday, Pageable pageable);

	
	List<BookTicket>findByStatusbook_Idstatusbook(int Idstatusbook);
	
	@Query("Select b from BookTicket b where b.ticket.bus.route.place like %:place%")
	List<BookTicket>findByRoute(@Param("place") String place);
	
	@Query("Select b from BookTicket b where b.ticket.bus.route.place like %:place% and b.statusbook.idstatusbook = :Idstatusbook")
	List<BookTicket>findByRouteandStatus(@Param("place") String place,@Param("Idstatusbook") int Idstatusbook);
}
