package com.devho.javatoy.model;

import com.devho.javatoy.BaseTimeEntity;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserProject extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id; // ID
    String title; // 제품이름
    double price; // 제품가격
    int inventory; // 재고수량
}
