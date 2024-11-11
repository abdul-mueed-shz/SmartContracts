package com.olab.smart.contract.adapter.out.persistence.entity;

import static com.olab.smart.contract.adapter.in.web.constants.DatabaseConstants.PARTICIPANT_SCHEMA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = PARTICIPANT_SCHEMA)
@EntityListeners({AuditingEntityListener.class})
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates ID for each new Customer
    private Long id;

    private String address;
    private String role;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime joinedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private SmartContract smartContract;
}
