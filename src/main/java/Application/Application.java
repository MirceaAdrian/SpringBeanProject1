package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * A small Spring Boot demo used to showcase the usage of a REST service with OXM serialization using DTOs
 *
 * @author bogdan.solga
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
