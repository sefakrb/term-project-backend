package com.example.termprojectbackend.service;

import com.example.termprojectbackend.data.dto.ContractDto;
import com.example.termprojectbackend.data.entity.Contract;
import com.example.termprojectbackend.data.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public HashMap<String, Object> create(Contract contract) {
        HashMap<String, Object> response = new HashMap<>();

        if (contract.getNftName() == "" || contract.getNftUri() == "") {
            response.put("code", 1);
            response.put("error", "Nft Name or URI can not be empty!");
            return response;
        }

        Contract createdContract = contractRepository.save(contract);
        if (createdContract.getId() != null) {
            response.put("code" , 0);
            response.put("data" , createdContract);
        } else {
            response.put("code", 1);
        }

        return response;
    }
}
