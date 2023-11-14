package ru.infoza.grabcontact.service;

import ru.infoza.grabcontact.dto.GetcontactDTO;

import java.util.List;

public interface GetcontactService {

    List<GetcontactDTO> getGetcontactByNumber(String phone);

}
