package ru.infoza.grabcontact.service;

import org.springframework.stereotype.Service;
import ru.infoza.grabcontact.dto.PhoneDTO;
import ru.infoza.grabcontact.model.Phone;
import ru.infoza.grabcontact.repository.PhoneRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<PhoneDTO> getPhoneByNumber(String vcPhone) {
        List<Phone> phones = phoneRepository.findByVcPhone(vcPhone);
        // Map Phone entities to DTOs
        return phones.stream()
                .map(this::mapToPhoneDTO)
                .collect(Collectors.toList());
    }

    private PhoneDTO mapToPhoneDTO(Phone phone) {
        PhoneDTO dto = new PhoneDTO();
        dto.setPhone(phone.getVcPhone());
        dto.setFio(phone.getVcFio());
        dto.setBorn(phone.getDtBorn() != null ? phone.getDtBorn() : null);
        return dto;
    }
}
