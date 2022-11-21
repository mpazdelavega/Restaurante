package com.restaurante.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restaurante.backend.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	List<Reserva> findByClient_Id(int clientId);
	List<Reserva> findByClient_UserName(String clientEmail);
	void deleteByClient_Id(int clientId);
	Long countByClient_Id(int id);
	
	//@Query(value="select r.estado_reserva from mesa m inner join reserva r on m.id_mesa = r.id_mesa inner join hora_mesa hm on hm.id_mesa = m.id_mesa where r.id_mesa = ?1 and m.date = ?3 and r.estado_reserva = 'No Cancelado' and STR_TO_DATE(?2,'%H:%i') <=  date_add(STR_TO_DATE(hm.hora,'%H:%i'),interval 15 minute) and STR_TO_DATE(?2,'%H:%i') >= STR_TO_DATE(hm.hora,'%H:%i');", nativeQuery = true)
	//List<Reserva> findById_Mesa(int id_mesa, String hora_reserva, String dia_reserva);
	
	@Query(value="select * from reserva r inner join mesa m on m.id_mesa = r.id_mesa inner join hora_mesa hm on hm.id_mesa = m.id_mesa where r.id_mesa = ?1 and m.date = ?3 and r.estado_reserva = 'No Cancelado' and STR_TO_DATE(?2,'%H:%i') <=  date_add(STR_TO_DATE(hm.hora,'%H:%i'),interval 15 minute) and STR_TO_DATE(?2,'%H:%i') >= STR_TO_DATE(hm.hora,'%H:%i');", nativeQuery = true)
	List<Reserva> findById_Mesa(int id_mesa, String hora_reserva, String dia_reserva);
	
}
