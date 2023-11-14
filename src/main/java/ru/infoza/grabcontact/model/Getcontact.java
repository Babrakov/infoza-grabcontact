package ru.infoza.grabcontact.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "getcontact")
public class Getcontact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "phone", length = 50)
    private String phone;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "region_source", length = 50)
    private String region;

    @Column(name = "date")
    private LocalDate date;

}