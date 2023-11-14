package ru.infoza.grabcontact.service;

import ru.infoza.grabcontact.dto.NumbusterDTO;
import ru.infoza.grabcontact.dto.PhoneDTO;

import java.util.List;

public interface NumbusterService {

    List<NumbusterDTO> getNumbusterByNumber(String phone);

}
