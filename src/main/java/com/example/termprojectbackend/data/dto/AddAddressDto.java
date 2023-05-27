package com.example.termprojectbackend.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAddressDto {
    private final Long contractId;
    private final String contractAddress;
    public AddAddressDto(Long contractId, String contractAddress) {
        this.contractId = contractId;
        this.contractAddress = contractAddress;
    }

}
