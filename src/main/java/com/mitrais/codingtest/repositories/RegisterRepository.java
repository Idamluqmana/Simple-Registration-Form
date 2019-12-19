package com.mitrais.codingtest.repositories;

import com.mitrais.codingtest.entities.Register;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RegisterRepository extends CrudRepository<Register,Long> {
    Register findByEmail(String email);
}
