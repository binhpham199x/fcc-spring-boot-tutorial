package com.synaigy.runnerz;

import com.synaigy.runnerz.user.User;
import com.synaigy.runnerz.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class Application {
   private static final Logger log = LoggerFactory.getLogger(Application.class);

   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

//   @Bean
//   CommandLineRunner runner(RunRepository runRepository) {
//      return args -> {
//         Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
//
//         runRepository.create(run);
//      };
//   }

   @Bean
   CommandLineRunner runner(UserRestClient client){
      return args -> {
         List<User> users = client.findAll();
         System.out.println(users);
      };
   }

}
