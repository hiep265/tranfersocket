package com.example.napas.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class NapasRequest {
    private String messageType;
    private String primaryBitMap;
    private String secondaryBitMap;
    private String primaryAccountNumber;
    private String processingCode;
    private String transactionAmount;
    private String transmissionDateTime;
    private String systemTraceAuditNumber;
    private LocalTime localTransactionTime;
    private LocalDate localTransactionDate;
    private String acceptingInstitutionCountryCode;
    private String posEntryModeCode;
    private String posConditionCode;
    private String acceptingInstitutionId;
    private String retrievalReferenceNumber;
    private String cardAcceptorTerminalId;
    private String cardAcceptorId;
    private String cardAcceptorNameLocation;
    private String additionalDataPrivate;
    private String transactionCurrencyCode;
    private String userDefinedField;
    private String serviceCode;
    private String paymentCode;
    private String receivingInstitutionId;
    private String fromAccountId;
    private String toAccountId;
    private String contentTransfers;
    private String cardholderInfo;
    private String recordData;
    private String additionalRecordData;
    private String reserved;
    private String messageAuthenticationCode;
}
