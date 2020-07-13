package com.devho.javatoy;

import com.devho.javatoy.model.UserProject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


import com.devho.ComponentScanBasePackage;
import com.devho.javatoy.repository.UserProjectRepository;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanBasePackage.class})
@RestController//원래 컨트롤러에 작성한 어노테이션
@EnableJpaAuditing
public class Application {

    @Autowired
    private UserProjectRepository userProjectRepository;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            userProjectRepository.save(new UserProject(1, "iPad Mini", 500.5, 10));
            userProjectRepository.save(new UserProject(2, "iPad Pro", 1000.8, 5));
            userProjectRepository.save(new UserProject(3, "MacBook Pro", 2100.0, 2));
        };
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
