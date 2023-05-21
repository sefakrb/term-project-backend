package com.example.termprojectbackend.data.repository;

import com.example.termprojectbackend.data.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findContractById(Long id);

}
