package com.example.termprojectbackend.data.dto.bcapi.request;

public class CreateContractDto {
    String name;
    String uri;
    Boolean mintable;
    Boolean burnable;
    Boolean ownable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Boolean getMintable() {
        return mintable;
    }

    public void setMintable(Boolean mintable) {
        this.mintable = mintable;
    }

    public Boolean getBurnable() {
        return burnable;
    }

    public void setBurnable(Boolean burnable) {
        this.burnable = burnable;
    }

    public Boolean getOwnable() {
        return ownable;
    }

    public void setOwnable(Boolean ownable) {
        this.ownable = ownable;
    }
}
