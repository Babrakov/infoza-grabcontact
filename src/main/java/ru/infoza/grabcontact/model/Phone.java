package ru.infoza.grabcontact.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "vc_phone", nullable = false)
    private String vcPhone;

    @Column(name = "vc_fio")
    private String vcFio;

    @Column(name = "dt_born")
    private LocalDate dtBorn;

    @Column(name = "sex_id")
    private Byte sexId;

    @Column(name = "region_id")
    private Byte regionId;

    @Column(name = "town_id", columnDefinition = "smallint UNSIGNED")
    private Integer townId;

    @Lob
    @Column(name = "tx_location")
    private String txLocation;

    @Column(name = "vc_email")
    private String vcEmail;

    @Column(name = "vc_link")
    private String vcLink;

    @Column(name = "source_id")
    private Integer sourceId;

    @Lob
    @Column(name = "tx_rem")
    private String txRem;

    @Column(name = "bn_hash", length = 16)
    private String bnHash;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}