package com.restaurante.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.backend.entity.ShoppingCart;
import com.restaurante.backend.repository.ShoppingCartRepository;

import java.util.List;

@Service
@Transactional
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }
    public List<ShoppingCart> getListByClient(String userName){
        return this.shoppingCartRepository.findByClient_UserName(userName);
    }
    public void cleanShoppingCart(String clientId){
        this.shoppingCartRepository.deleteByClient_Id(clientId);
    }
    public void removeProduct(String id){
        this.shoppingCartRepository.deleteById(id);
    }
    public void addProduct(ShoppingCart shoppingCart){
        this.shoppingCartRepository.save(shoppingCart);
    }
    public Long getCountByClient(String clientId){
        return this.shoppingCartRepository.countByClient_Id(clientId);
    }
}
