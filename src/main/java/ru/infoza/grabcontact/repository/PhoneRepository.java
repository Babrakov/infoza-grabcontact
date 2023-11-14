package ru.infoza.grabcontact.repository;

import ru.infoza.grabcontact.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    List<Phone> findByVcPhone(String vcPhone);

}