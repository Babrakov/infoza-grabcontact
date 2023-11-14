package ru.infoza.grabcontact.service;

import ru.infoza.grabcontact.dto.PhoneDTO;

import java.util.List;

public interface PhoneService {

    List<PhoneDTO> getPhoneByNumber(String vcPhone);

}
