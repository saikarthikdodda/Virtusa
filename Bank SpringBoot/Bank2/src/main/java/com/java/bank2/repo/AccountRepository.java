package com.java.bank2.repo;

import com.java.bank2.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account,String> {
    Account findByAccountNo(int accountNo);
    Account findFirstByOrderByAccountNoDesc();
    void deleteByAccountNo(int accountNo);
}
