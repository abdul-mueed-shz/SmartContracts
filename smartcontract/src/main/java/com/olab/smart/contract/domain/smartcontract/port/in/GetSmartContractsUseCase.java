package com.olab.smart.contract.domain.smartcontract.port.in;

import com.olab.smart.contract.domain.smartcontract.model.SmartContractInfo;
import java.util.List;

public interface GetSmartContractsUseCase {

    List<SmartContractInfo> getContracts();
}
