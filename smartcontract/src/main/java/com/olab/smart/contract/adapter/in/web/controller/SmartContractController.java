package com.olab.smart.contract.adapter.in.web.controller;

import com.olab.smart.contract.adapter.in.web.mapper.SmartContractDtoMapper;
import com.olab.smart.contract.domain.enums.SmartContractMessageCodeEnum;
import com.olab.smart.contract.domain.smartcontract.port.in.CreateSmartContractUseCase;
import com.olab.smart.contract.domain.smartcontract.port.in.DeleteSmartContractUseCase;
import com.olab.smart.contract.domain.smartcontract.port.in.GetSmartContractDetailUseCase;
import com.olab.smart.contract.domain.smartcontract.port.in.GetSmartContractsUseCase;
import com.olab.smart.contract.domain.smartcontract.port.in.UpdateSmartContractUseCase;
import com.olab.smart.contract.dto.CreateSmartContractRequest;
import com.olab.smart.contract.dto.MessageInfo;
import com.olab.smart.contract.dto.UpdateSmartContractRequest;
import com.olab.smart.contract.dto.SmartContractResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/smart-contracts")
@RequiredArgsConstructor
public class SmartContractController {

    private final CreateSmartContractUseCase createSmartContractUseCase;
    private final GetSmartContractsUseCase getSmartContractsUseCase;
    private final UpdateSmartContractUseCase updateSmartContractUseCase;
    private final GetSmartContractDetailUseCase getSmartContractDetailUseCase;
    private final DeleteSmartContractUseCase deleteSmartContractUseCase;
    private final SmartContractDtoMapper smartContractDtoMapper;

    @PostMapping
    public ResponseEntity<MessageInfo> createSmartContract(
            @Valid @RequestBody CreateSmartContractRequest createSmartContractRequest) {
        Long contractId =
                createSmartContractUseCase.createContract(smartContractDtoMapper.map(createSmartContractRequest));
        return ResponseEntity.ok(
                createMessageInfo(contractId,
                        SmartContractMessageCodeEnum.SMART_CONTRACT_CREATED_SUCCESSFULLY.getMessageDescription(),
                        SmartContractMessageCodeEnum.SMART_CONTRACT_CREATED_SUCCESSFULLY.getMessageCode())
        );
    }

    @PutMapping
    public ResponseEntity<MessageInfo> updateSmartContract(@Valid
    @RequestBody UpdateSmartContractRequest updateSmartContractRequest) {
        updateSmartContractUseCase.updateContract(smartContractDtoMapper.map(updateSmartContractRequest));
        return ResponseEntity.ok(
                createMessageInfo(updateSmartContractRequest.getId(),
                        SmartContractMessageCodeEnum.SMART_CONTRACT_UPDATED_SUCCESSFULLY.getMessageDescription(),
                        SmartContractMessageCodeEnum.SMART_CONTRACT_UPDATED_SUCCESSFULLY.getMessageCode())
        );
    }

    @GetMapping
    public ResponseEntity<List<SmartContractResponse>> getSmartContracts() {
        return ResponseEntity.ok(smartContractDtoMapper.map(getSmartContractsUseCase.getContracts()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SmartContractResponse> getSmartContractDetail(@PathVariable("id") Long contractId) {
        return ResponseEntity
                .ok(smartContractDtoMapper.map(getSmartContractDetailUseCase.getContractDetail(contractId)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MessageInfo> deleteById(@PathVariable("id") Long contractId) {
        deleteSmartContractUseCase.deleteById(contractId);
        return ResponseEntity.ok(
                createMessageInfo(
                        contractId,
                        SmartContractMessageCodeEnum.SMART_CONTRACT_DELETED_SUCCESSFULLY.getMessageDescription(),
                        SmartContractMessageCodeEnum.SMART_CONTRACT_DELETED_SUCCESSFULLY.getMessageCode()
                )
        );
    }

    private MessageInfo createMessageInfo(Long displayableId, String messageDescription, String messageCode) {
        var messageInfo = new MessageInfo();
        messageInfo.setId(displayableId);
        messageInfo.setDisplayableId(displayableId.toString());
        messageInfo.setDisplayableName(displayableId.toString());
        messageInfo.setMessageDescription(messageDescription);
        messageInfo.setMessageCode(messageCode);
        return messageInfo;
    }

}
