package com.example.termprojectbackend.data.dto.bcapi.response;

import java.io.Serializable;
import java.lang.reflect.Array;

public class CreateContractResponse implements Serializable {
    String abi;
    String byteCode;
    String mainContract;

    public String getAbi() {
        return abi;
    }
    public void setAbi(String abi) {
        this.abi = abi;
    }
    public String getByteCode() {
        return byteCode;
    }
    public void setByteCode(String byteCode) {
        this.byteCode = byteCode;
    }
    public String getMainContract() {
        return mainContract;
    }
    public void setMainContract(String mainContract) {
        this.mainContract = mainContract;
    }
}
