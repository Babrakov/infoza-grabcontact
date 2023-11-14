package ru.infoza.grabcontact.service;

import org.springframework.stereotype.Service;
import ru.infoza.grabcontact.dto.GetcontactDTO;
import ru.infoza.grabcontact.dto.NumbusterDTO;
import ru.infoza.grabcontact.model.Getcontact;
import ru.infoza.grabcontact.model.Numbuster;
import ru.infoza.grabcontact.repository.GetcontactRepository;
import ru.infoza.grabcontact.repository.NumbusterRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetcontactServiceImpl implements GetcontactService {

    private final GetcontactRepository getcontactRepository;

    public GetcontactServiceImpl(GetcontactRepository getcontactRepository) {
        this.getcontactRepository = getcontactRepository;
    }

    @Override
    public List<GetcontactDTO> getGetcontactByNumber(String phone) {
        List<Getcontact> getcontactList = getcontactRepository.findByPhone(phone);
        // Map Getcontact entities to DTOs
        return getcontactList.stream()
                .map(this::mapToGetcontactDTO)
                .collect(Collectors.toList());
    }

    private GetcontactDTO mapToGetcontactDTO(Getcontact getcontact) {
        GetcontactDTO dto = new GetcontactDTO();
        dto.setPhone(getcontact.getPhone());
        dto.setName(getcontact.getName());
        dto.setRegion(getcontact.getRegion());
        return dto;
    }

}
