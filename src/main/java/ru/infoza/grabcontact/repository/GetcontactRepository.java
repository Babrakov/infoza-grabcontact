package ru.infoza.grabcontact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.infoza.grabcontact.model.Getcontact;
import ru.infoza.grabcontact.model.Numbuster;

import java.util.List;

public interface GetcontactRepository extends JpaRepository<Getcontact, Long> {

    List<Getcontact> findByPhone(String phone);

}