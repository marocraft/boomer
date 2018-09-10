package ma.craft.boomer;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class Main {
	
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(Main.class);



	public static void main(String[] args) {
		logger.error("Sample error message");

		logger.info("< Démarage de l'application");
		SpringApplication.run(Main.class, args);
		logger.info("> Arrêt de l'application");


	}

}
