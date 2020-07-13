package com.devho.javatoy.controller;
import java.util.List;

import com.devho.javatoy.repository.UserProjectRepository;
import com.devho.javatoy.model.UserProject;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@NoArgsConstructor
@RestController
@Data
public class UserProjectController {

    @Autowired
    private UserProjectRepository userProjectRepository;

    @GetMapping(value = "/")
    public String hello() {
        return "hello world!!!";
    }

    // 1. 공개된 프로젝트 리스트로 보여주는 api
    @RequestMapping("/project")
    public List<UserProject> getProducts() {
        return userProjectRepository.findAll();
    }

    @RequestMapping("/project/{id}")
    public UserProject getProductById(@PathVariable("id") Long id) {
        return userProjectRepository.findById(id).get();
    }


    @GetMapping(value = "/read")
    public Object read() {
        return userProjectRepository.findAll();
    }

    @GetMapping(value = "/delete")
    public Object delete() {
        userProjectRepository.deleteAll();
        return "delete";
    }
}
