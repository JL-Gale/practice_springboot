package com.app.persistence;

import com.app.entities.Employe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeRepository extends CrudRepository<Employe, Long> {

}
