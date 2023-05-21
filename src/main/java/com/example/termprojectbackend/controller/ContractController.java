package com.example.termprojectbackend.controller;

import com.example.termprojectbackend.data.dto.ContractDto;
import com.example.termprojectbackend.data.entity.Contract;
import com.example.termprojectbackend.service.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/contract")
@CrossOrigin(origins = "http://localhost:3000")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping(path = "/create")
    public HashMap<String, Object> create(@RequestBody ContractDto contract) {
        Contract newContract = new Contract();
        BeanUtils.copyProperties(contract, newContract);
        HashMap<String, Object> response = contractService.create(newContract);
        // js backend istek at
        //
        return response;
    }

}
