package com.example.termprojectbackend.data.repository;

import com.example.termprojectbackend.data.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findContractById(Long id);

    ArrayList<Contract> findContractsByUserId(Long userId);

    Contract findContractsByAddress(String address);

}
