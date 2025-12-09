package com.java.eurekaemployclientv.repository;

import com.java.eurekaemployclientv.model.Employ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepository extends JpaRepository<Employ,Integer> {

}
