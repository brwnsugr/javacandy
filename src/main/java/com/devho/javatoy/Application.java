package com.devho.javatoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.devho.ComponentScanBasePackage;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanBasePackage.class})
@RestController//원래 컨트롤러에 작성한 어노테이션
public class Application {

    @RequestMapping("/") // 원래 컨트롤러에 작성할 매서드
    public String Hello(){
        return "Hello world!";
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
