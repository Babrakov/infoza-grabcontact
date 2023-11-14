package ru.infoza.grabcontact.service;

import org.springframework.stereotype.Service;
import ru.infoza.grabcontact.dto.NumbusterDTO;
import ru.infoza.grabcontact.dto.PhoneDTO;
import ru.infoza.grabcontact.model.Numbuster;
import ru.infoza.grabcontact.model.Phone;
import ru.infoza.grabcontact.repository.NumbusterRepository;
import ru.infoza.grabcontact.repository.PhoneRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NumbusterServiceImpl implements NumbusterService {

    private final NumbusterRepository numbusterRepository;

    public NumbusterServiceImpl(NumbusterRepository numbusterRepository) {
        this.numbusterRepository = numbusterRepository;
    }

    @Override
    public List<NumbusterDTO> getNumbusterByNumber(String phone) {
        List<Numbuster> numbusters = numbusterRepository.findByPhone(phone);
        // Map Numbuster entities to DTOs
        return numbusters.stream()
                .map(this::mapToNumbusterDTO)
                .collect(Collectors.toList());
    }

    private NumbusterDTO mapToNumbusterDTO(Numbuster numbuster) {
        NumbusterDTO dto = new NumbusterDTO();
        dto.setPhone(numbuster.getPhone());
        dto.setName(numbuster.getName());
        dto.setRegion(numbuster.getRegion());
        return dto;
    }

}
