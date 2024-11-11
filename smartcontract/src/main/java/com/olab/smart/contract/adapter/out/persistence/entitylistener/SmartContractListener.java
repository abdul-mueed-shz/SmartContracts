package com.olab.smart.contract.adapter.out.persistence.entitylistener;

import com.olab.smart.contract.adapter.out.persistence.entity.SmartContract;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;

public class SmartContractListener {

    private static final Integer PADDING_SIZE = 8;

    public static String prepareDisplayableId(String prefix, Long id) {
        String format = "%0" + PADDING_SIZE + "d";
        var formattedNumber = String.format(format, id);
        return prefix + formattedNumber;
    }

    @PostPersist
    @PostUpdate
    public void setVersionNumber(SmartContract smartContract) {
        if (smartContract.getId() != null) {
            String displayableId = prepareDisplayableId("V", smartContract.getId());
            smartContract.setVersion(displayableId);
        }
    }
}
