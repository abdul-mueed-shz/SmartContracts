package com.olab.smart.contract.domain.smartcontract.port.out.repository;

import com.olab.smart.contract.domain.smartcontract.model.SmartContractInfo;
import com.olab.smart.contract.domain.smartcontract.model.SmartContractRecord;
import java.util.List;

public interface SmartContractRepository {

    Long saveContract(SmartContractRecord smartContractRecord);

    List<SmartContractInfo> getContracts();

    SmartContractInfo getContractDetail(Long contractId);

    void updateContract(SmartContractRecord smartContractRecord);

    Boolean existById(Long contractId);

    void deleteById(Long contractId);
}
