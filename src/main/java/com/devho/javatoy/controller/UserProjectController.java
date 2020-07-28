package com.devho.javatoy.controller;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//Autowired 는 IoC 안에 있는 컨테이너의 존재하는 Bean 을 자동으로 주입해줌
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.devho.javatoy.repository.UserProjectRepository;
import com.devho.javatoy.model.UserProject;

@Api(tags = {"1. User Project"})
@RestController
@RequestMapping("/api/v1")
public class UserProjectController {

    @Autowired
    private UserProjectRepository userProjectRepository; // autowired 를 통해 해당 객체 주입

    @ApiOperation(value="list project", notes="get list of the projects")
    @GetMapping("/projects") // url routes
    public Page<UserProject> getProjects(@PageableDefault(size=10) Pageable pageable,
                                         @RequestParam("정렬 대상(start_date, finish_date, ")String sort_name,
                                         @RequestParam("정렬 순서(asc/desc)")String order) {
        return userProjectRepository.findAll(pageable); // repo 인터페이스에 정의된 매소드
    }

    @GetMapping("/project/{id}") // pathvariable 어노테이션을 통해 id를 path에 명시적으로 받음
    public UserProject getProductById(@PathVariable("id") int id) {
        return userProjectRepository.findById(id).get();
    }


    @PostMapping("/new_project")
    public UserProject createEmployee(@Valid @RequestBody UserProject userProject) {
        return userProjectRepository.save(userProject);
    }


    @GetMapping(value = "/delete")
    public Object delete() {
        userProjectRepository.deleteAll();
        return "delete";
    }
}
