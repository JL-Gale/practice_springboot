package com.app.persistence;

import com.app.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeRepository extends JpaRepository<Employe, Long> {

}
