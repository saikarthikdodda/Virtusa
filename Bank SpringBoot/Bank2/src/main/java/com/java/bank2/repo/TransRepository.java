package com.java.bank2.repo;

import com.java.bank2.model.Trans;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransRepository extends CrudRepository<Trans, String> {
    List<Trans> findByAccountNo(int accountNo);
}
