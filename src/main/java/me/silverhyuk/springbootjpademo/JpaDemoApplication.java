package me.silverhyuk.springbootjpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryImplementationPostfix = "Impl")
public class JpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }
}
