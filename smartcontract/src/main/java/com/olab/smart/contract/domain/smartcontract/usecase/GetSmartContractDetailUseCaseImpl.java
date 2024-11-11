package com.olab.smart.contract.domain.smartcontract.usecase;

import com.olab.smart.contract.adapter.out.persistence.adapter.SmartContractRepositoryAdapter;
import com.olab.smart.contract.domain.smartcontract.model.SmartContractInfo;
import com.olab.smart.contract.domain.smartcontract.port.in.GetSmartContractDetailUseCase;
import com.olab.smart.contract.domain.smartcontract.port.out.repository.SmartContractRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class GetSmartContractDetailUseCaseImpl implements GetSmartContractDetailUseCase {

    private final SmartContractRepository smartContractRepository;

    @Override
    public SmartContractInfo getContractDetail(Long contractId) {
        if (Boolean.FALSE.equals(smartContractRepository.existById(contractId))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Smart Contract not found");
        }
        return smartContractRepository.getContractDetail(contractId);
    }
}
