package com.olab.smart.contract.domain.smartcontract.usecase;

import com.olab.smart.contract.domain.smartcontract.port.in.DeleteSmartContractUseCase;
import com.olab.smart.contract.domain.smartcontract.port.out.repository.SmartContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DeleteSmartContractUseCaseImpl implements DeleteSmartContractUseCase {

    private final SmartContractRepository smartContractRepository;

    @Override
    public void deleteById(Long contractId) {
        if (Boolean.FALSE.equals(smartContractRepository.existById(contractId))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Smart Contract not found");
        }
        smartContractRepository.deleteById(contractId);
    }
}
