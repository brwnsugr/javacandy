package com.devho.javatoy.model;

import com.devho.javatoy.BaseTimeEntity;
import java.util.Date;
import lombok.*;

import javax.persistence.*;


@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "USERPROJECT")
@Entity
public class UserProject extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id; // ID

    @Column(name = "title", length = 100, nullable = false)
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "creator_name", length = 20)
    String creator_name;

    @Column(name = "email")
    String email;

    @Column(name = "phone", length = 20)
    String phone;

    @Column(name = "start_date")
    Date start_date;

    @Column(name = "finish_date")
    Date finish_date;

    @Column(name = "target_amount")
    int target_amount;

    @Column(name = "donated_count")
    int donated_count;

    @Column(name = "donated_amount")
    int donated_amount;

    @Column(name = "public_yn")
    boolean public_yn;

    @Column(name = "status")
    String status;

    public UserProject(){

    }

    public UserProject(int id, String title, String description, String creator_name, String email,
                String phone, Date start_date, Date finish_date, int target_amount, int donated_count, int donated_amount, boolean public_yn, String status){
        this.id = id;
        this.title = title;
        this.description = description;
        this.creator_name = creator_name;
        this.email = email;
        this.phone = phone;
        this.start_date = start_date;
        this.finish_date = finish_date;
        this.target_amount = target_amount;
        this.donated_count = donated_count;
        this.donated_amount = donated_amount;
        this.public_yn = public_yn;
        this.status = status;
    }



}
