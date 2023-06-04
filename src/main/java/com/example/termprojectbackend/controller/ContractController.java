package com.example.termprojectbackend.controller;

import com.example.termprojectbackend.data.dto.AddAddressDto;
import com.example.termprojectbackend.data.dto.ContractDto;
import com.example.termprojectbackend.data.entity.Contract;
import com.example.termprojectbackend.service.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/contract")
@CrossOrigin(origins = "*")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping(path = "/create")
    public HashMap<String, Object> create(@RequestBody ContractDto contract) {
        if (contract.getId() == -1) {
            HashMap<String, Object> response = new HashMap<>();
            response.put("code", 1);
            response.put("error", "Id is wrong!");
            return response;
        }
        Contract newContract = new Contract();
        BeanUtils.copyProperties(contract, newContract);
        return contractService.create(newContract);
    }

    @PostMapping(path = "/add-address")
    public HashMap<String, Object> addAddress(@RequestBody AddAddressDto updateData) {
        return contractService.addAddress(updateData);
    }

}
