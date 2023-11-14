package ru.infoza.grabcontact.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NumbusterDTO {

    private String phone;
    private String name;
    private String region;
}
