package fr.piroxxi.ruel_li_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RuelliApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuelliApplication.class, args);
    }

}
