package ma.craft.boomer.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import ma.craft.boomer.demo.entities.InterRepoPromotion;
import ma.craft.boomer.demo.entities.InterReposetory;
import ma.craft.boomer.demo.entities.PromotionB;
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients

public class ProjetTestApplication {

	public static void main(String[] args) {
		ApplicationContext contx = SpringApplication.run(ProjetTestApplication.class, args);
		InterReposetory ir = contx.getBean(InterReposetory.class);
		InterRepoPromotion ip = contx.getBean(InterRepoPromotion.class);
	
		for(int i=0; i<10; i++) {
			ip.save(new PromotionB(i+"/09/2018", i+"/10/2018", "promotion de l'été", 50+(i*3), false));
			
			}
		ip.save(new PromotionB("12/09/2018", "12/10/2018", "promotion de l'été", 60, true));
		
	}
}
