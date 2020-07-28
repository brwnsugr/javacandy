package com.devho.javatoy.repository;

import com.devho.javatoy.model.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 이 인터페이스가 jparepository 임을 명시해주는 어노테이션임 (반드시 붙어야 함)
public interface UserProjectRepository extends JpaRepository<UserProject, Integer>{
    //JpaRepository <엔티티 형, 엔티티 id의 형>
}
