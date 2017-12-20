package courseManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@ComponentScan(basePackages={"courseManagement.view"})
public class Application {

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);
    }

}
