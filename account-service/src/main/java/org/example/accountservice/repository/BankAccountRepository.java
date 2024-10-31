package org.example.accountservice.repository;

import org.example.accountservice.entitiies.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository  extends JpaRepository<BankAccount, String> {
}
