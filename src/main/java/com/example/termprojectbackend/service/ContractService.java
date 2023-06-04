package com.example.termprojectbackend.service;

import com.example.termprojectbackend.data.dto.AddAddressDto;
import com.example.termprojectbackend.data.dto.bcapi.request.CreateContractDto;
import com.example.termprojectbackend.data.dto.bcapi.response.CreateContractResponse;
import com.example.termprojectbackend.data.entity.Contract;
import com.example.termprojectbackend.data.entity.User;
import com.example.termprojectbackend.data.repository.ContractRepository;
import com.example.termprojectbackend.data.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public ContractService(ContractRepository contractRepository,
                           UserRepository userRepository,
                           RestTemplate restTemplate) {
        this.contractRepository = contractRepository;
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public HashMap<String, Object> create(Contract contract) {
        HashMap<String, Object> response = new HashMap<>();

        if (Objects.equals(contract.getNftName(), "") || Objects.equals(contract.getNftUri(), "")) {
            response.put("code", 1);
            response.put("error", "Nft Name or URI can not be empty!");
            return response;
        }

        String url = "https://term-project-bc-production-9efe.up.railway.app/contract/create";

        CreateContractDto request = new CreateContractDto();

        request.setName(contract.getNftName());
        request.setUri(contract.getNftUri());
        request.setMintable(contract.getIsMintable());
        request.setBurnable(contract.getIsBurnable());
        request.setOwnable(contract.getIsOwnable());

        CreateContractResponse createContractResponse = restTemplate.postForObject(url, request, CreateContractResponse.class);

        if (createContractResponse != null) {
            contract.setAbi(createContractResponse.getAbi());
            contract.setByteCode(createContractResponse.getByteCode());
            contract.setMainContract(createContractResponse.getMainContract());
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

    public HashMap<String, Object> addAddress(AddAddressDto updateData) {
        HashMap<String, Object> response = new HashMap<>();

        if (Objects.equals(updateData.getContractAddress(), "") || updateData.getContractId() == null) {
            response.put("code", 1);
            response.put("error", "Hash code or contract ID is empty!");
            return response;
        }

        Contract contract = contractRepository.findContractById(updateData.getContractId());

        if (contract != null) {
            contract.setAddress(updateData.getContractAddress());
            contractRepository.save(contract);
            response.put("code" , 0);
            response.put("data" , contract);
        } else {
            response.put("code", 1);
        }

        return response;
    }

    public HashMap<String, Object> contractAddresses(Long userId) {
        HashMap<String, Object> response = new HashMap<>();

        User user = userRepository.findUserById(userId);
        if (user == null) {
            response.put("code", 1);
            response.put("error", "User is not exist!");
            return response;
        }

        ArrayList<Contract> contracts = contractRepository.findContractsByUserId(userId);

        response.put("code" , 0);
        response.put("data" , contracts);

        return response;
    }
}
