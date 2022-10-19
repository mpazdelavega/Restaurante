package com.restaurante.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.restaurante.backend.entity.ShoppingCart;
import java.util.List;


public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {
    List<ShoppingCart> findByClient_Id(String clientId);
    @Query(value="select * from shopping_cart sc inner join users u on sc.client_id = u.id where u.user_name = ?1 and estado_pedido = 'Solicitado'", nativeQuery = true)
    List<ShoppingCart> findByClient_UserName(String clientEmail);
    
    @Query(value="select * from shopping_cart sc inner join users u on sc.client_id = u.id where u.user_name = ?1 and estado_pedido = 'Seleccionado'", nativeQuery = true)
    List<ShoppingCart> findByClient_UserNameAndStatus(String clientEmail);
    void deleteByClient_Id(String clientId);
    Long countByClient_Id(String id);	
    
    @Modifying
    @Query(value="update shopping_cart set estado_pedido= 'Solicitado' where client_id = ?1", nativeQuery = true)
    void updateByClient_Id(String client_id);
    
    /*
    @Query(value="update shopping_cart sc inner join users u on sc.client_id = u.id set sc.estado_pedido= 'Solicitado' where u.user_name = ?1", nativeQuery = true)
    void updateByClient_Id(String client_id);
    */
   
}
