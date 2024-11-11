package com.olab.smart.contract.adapter.out.persistence.entity;

import static com.olab.smart.contract.adapter.in.web.constants.DatabaseConstants.SMART_CONTRACT_SCHEMA;

import com.olab.smart.contract.adapter.out.persistence.entitylistener.SmartContractListener;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = SMART_CONTRACT_SCHEMA)
@EntityListeners({AuditingEntityListener.class, SmartContractListener.class})
public class SmartContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates ID for each new Customer
    private Long id;

    private String version;
    private String creatorAddress;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;              // Timestamp of the last update

    private String description;          // Brief description of the contract

    private Boolean isActive;            // Whether the contract is active

    @OneToMany(mappedBy = "smartContract", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Participant> participants;
}
