package ru.infoza.grabcontact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.infoza.grabcontact.model.Numbuster;
import ru.infoza.grabcontact.model.Phone;

import java.util.List;

public interface NumbusterRepository extends JpaRepository<Numbuster, Long> {

    List<Numbuster> findByPhone(String phone);

}