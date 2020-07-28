package com.devho.javatoy;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate; // Entity가 생성되어 저장될 때 시간이 자동 저장
import org.springframework.data.annotation.LastModifiedDate; // 조회한 Entity의 값을 변경할 때 시간이 자동 저장
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners; // entity 데이터 변경시, 콜백되는 class ,
import javax.persistence.MappedSuperclass; // mapping 정보는 상속 받는 superclass , JPA에서 @Entity 클래스는 @Entity나 @MappedSuperclass로 지정한 클래스만 상속할 수 있다.
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 해당 추상 클래스를 상속할 경우 createDate, modifiedDate를 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}

