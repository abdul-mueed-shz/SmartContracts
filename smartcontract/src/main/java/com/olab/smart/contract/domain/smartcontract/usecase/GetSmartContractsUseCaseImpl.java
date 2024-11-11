package com.olab.smart.contract.domain.smartcontract.usecase;

import com.olab.smart.contract.domain.smartcontract.model.SmartContractInfo;
import com.olab.smart.contract.domain.smartcontract.port.in.GetSmartContractsUseCase;
import com.olab.smart.contract.domain.smartcontract.port.out.repository.SmartContractRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSmartContractsUseCaseImpl implements GetSmartContractsUseCase {

    private final SmartContractRepository smartContractRepository;


    @Override
    public List<SmartContractInfo> getContracts() {
        return smartContractRepository.getContracts();
    }

}
