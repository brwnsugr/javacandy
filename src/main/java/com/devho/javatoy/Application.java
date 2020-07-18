package com.devho.javatoy;

import java.util.Date;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


import com.devho.ComponentScanBasePackage;
import com.devho.javatoy.model.UserProject;
import com.devho.javatoy.repository.UserProjectRepository;


@EnableJpaRepositories
@SpringBootApplication(scanBasePackageClasses = {ComponentScanBasePackage.class})
@RestController//원래 컨트롤러에 작성한 어노테이션
@EnableJpaAuditing
public class Application {

    @Autowired
    UserProjectRepository userProjectRepository;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Date current_time = new Date();
            userProjectRepository.save(new UserProject(1, "title", "설명", "user_name1", "ddd@gmail.com", "010-2020-2020", current_time, current_time, 100, 3, 20, true, "ING"));
        };
    }



    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
