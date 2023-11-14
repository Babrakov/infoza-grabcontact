package ru.infoza.grabcontact.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PhoneDTO {

    private String phone;
    private String fio;
    private LocalDate born;
}
