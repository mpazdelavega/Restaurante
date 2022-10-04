package com.restaurante.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.backend.entity.Product;
import com.restaurante.backend.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void saveProduct(Product product){
        this.productRepository.save(product);
    }
   public List<Product> getAllProducts(){
        return this.productRepository.findAll();
   }
   public List<Product> getRelatedProducts(String category, String productId){
        List<Product> productList = this.productRepository.findByCategoryAndIdNot(category,productId);
        List<Product> randomProducts = new ArrayList<>();
       Random random = new Random();
	   for(int i = 0; i < 2; i++){
		   if(!productList.isEmpty())
		   {
			   int randomIndex = random.nextInt(productList.size());
               randomProducts.add(productList.get(randomIndex));
               productList.remove(randomIndex);
		   }
           
       }
       
       
       return randomProducts;
   }
   public Optional<Product> getProductById(String id){
        return this.productRepository.findById(id);
   }
   public List<Product> getBestPriceProducts(){
        return this.productRepository.findFirst4ByOrderByPriceAsc();
   }
}
