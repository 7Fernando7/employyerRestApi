package org.example.repositories;

import org.example.entities.EmployeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeersRepository extends JpaRepository<EmployeerEntity, Integer> {
    List<EmployeerEntity> findAll(); //NamedQueries
}
