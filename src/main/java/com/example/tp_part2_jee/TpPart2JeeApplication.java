package com.example.tp_part2_jee;

import com.example.tp_part2_jee.entities.Product;
import com.example.tp_part2_jee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TpPart2JeeApplication implements CommandLineRunner {
	@Autowired
private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(TpPart2JeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*productRepository.save(new Product(null,"computer",4300,3));
		productRepository.save(new Product(null,"SmartPhone",2000,3));
		productRepository.save(new Product(null,"Monitor",5000,3));*/
		List<Product> products=productRepository.findAll();
		products.forEach(p-> {
			System.out.println(p.toString());
		});
		Product product =productRepository.findById(Long.valueOf(3)).get();
		System.out.println("----------------------------");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getQuantity());
		System.out.println("----------------------------");
		System.out.println("********************");
		/*List<Product> productList=productRepository.findByNameContains("S");
		products.forEach(p-> {
			System.out.println(p);
		});*/

		System.out.println("****************");
		List<Product> productList2=productRepository.searchByPrice(1000);
		products.forEach(p-> {
			System.out.println(p);
		});


	}
}
