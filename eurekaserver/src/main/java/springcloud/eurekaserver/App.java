package springcloud.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class App {

//  @RequestMapping("/")
//  public String home() {
//    return "Hello World";
//  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

}


