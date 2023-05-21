package com.example.termprojectbackend.data.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractDto {
    private final Long id;
    private final Long userId;
    private final String nftName;
    private final String nftUri;
    private final Boolean isMintable;
    private final Boolean isBurnable;
    private final Boolean isOwnable;

    public ContractDto(Long id, Long userId, String nftName, String nftUri, Boolean isMintable, Boolean isBurnable, Boolean isOwnable) {
        this.id = id;
        this.userId = userId;
        this.nftName = nftName;
        this.nftUri = nftUri;
        this.isMintable = isMintable;
        this.isBurnable = isBurnable;
        this.isOwnable = isOwnable;
    }
}
