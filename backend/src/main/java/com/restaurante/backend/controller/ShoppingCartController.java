package com.restaurante.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.restaurante.backend.entity.Message;
import com.restaurante.backend.entity.ShoppingCart;
import com.restaurante.backend.service.ShoppingCartServiceImpl;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/shoppingList")
public class ShoppingCartController {
    private final ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartServiceImpl shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping()
    public ResponseEntity<List<ShoppingCart>> getListByClient(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String userName = userDetails.getUsername();
        return new ResponseEntity<>(this.shoppingCartService.getListByClient(userName), HttpStatus.OK);
    }
    
    @GetMapping("/status")
    public ResponseEntity<List<ShoppingCart>> getListByClientAndStatus(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String userName = userDetails.getUsername();
        return new ResponseEntity<>(this.shoppingCartService.getListByClientAndState(userName), HttpStatus.OK);
    }
    
    @GetMapping("/count/{client_id}")
    public ResponseEntity<Long> countByClient(@PathVariable("client_id")int id){
        return new ResponseEntity<>(this.shoppingCartService.getCountByClient(id),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Message> addProduct(@Valid @RequestBody ShoppingCart shoppingCart,
                                              BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Revise los campos"),HttpStatus.BAD_REQUEST);
        this.shoppingCartService.addProduct(shoppingCart);
        return new ResponseEntity<>(new Message("Producto agregado"),HttpStatus.OK);
    }
    @DeleteMapping("/clean/{item_id}")
    public ResponseEntity<Message> removeProduct(@PathVariable("item_id")String id){
        this.shoppingCartService.removeProduct(id);
        return new ResponseEntity<>(new Message("Eliminado"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{client_id}")
	private ResponseEntity<Message> add(@PathVariable("client_id") int id)
	{
    	System.out.println("Controller: " + id);
    	shoppingCartService.updateShoppingCart(id);
    	return new ResponseEntity<>(new Message("Actualizado"),HttpStatus.OK);
	}
}
