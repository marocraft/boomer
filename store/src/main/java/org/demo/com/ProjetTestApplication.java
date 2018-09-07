package org.demo.com;


import org.demo.com.entities.Book;
import org.demo.com.entities.InterRepoPromotion;
import org.demo.com.entities.InterReposetory;
import org.demo.com.entities.PromotionA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProjetTestApplication {

	public static void main(String[] args) {
		ApplicationContext contx = SpringApplication.run(ProjetTestApplication.class, args);
		InterReposetory ir = contx.getBean(InterReposetory.class);
		InterRepoPromotion ip = contx.getBean(InterRepoPromotion.class);
		/*
		for(int i=0; i<10; i++) {
		ir.save(new Book("aaaaaaaa"+i, "jawadi"+i, "bbbbb"+i, 15));
		
		}
		
		Book book = new Book();
				book=ir.getOne(1L);
		System.out.println(book.getAutor()+"***"+book.getDescription());
		
		for(int i=0; i<10; i++) {
			ip.save(new PromotionA(i+"/09/2018", i+"/10/2018", "promotion de l'été", 50));
			
			}*/
	}
}
