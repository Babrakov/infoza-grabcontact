package ru.infoza.grabcontact.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "numbuster")
public class Numbuster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "region", length = 100)
    private String region;

    @Column(name = "phone", length = 11)
    private String phone;

    @Lob
    @Column(name = "name")
    private String name;

}