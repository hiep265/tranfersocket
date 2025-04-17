package com.example.napas.controller;

import java.util.Random;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.napas.DTO.NapasRequest;
import com.example.napas.DTO.NapasResponse;

@RestController
@RequestMapping("/api/napas")
public class NapasController {

    @PostMapping("/process")
    public NapasResponse processTransaction(@RequestBody NapasRequest request) {
        // Giả lập phản hồi từ Napas
        int randomCase = new Random().nextInt(4); // 0, 1, 2, 3
        switch (randomCase) {
            case 0:
                // Trường hợp thành công: map toàn bộ dữ liệu từ request sang response
                NapasResponse successResponse = new NapasResponse("00");
                successResponse.setMessageType(request.getMessageType());
                successResponse.setPrimaryBitMap(request.getPrimaryBitMap());
                successResponse.setSecondaryBitMap(request.getSecondaryBitMap());
                successResponse.setPrimaryAccountNumber(request.getPrimaryAccountNumber());
                successResponse.setProcessingCode(request.getProcessingCode());
                successResponse.setTransactionAmount(request.getTransactionAmount());
                successResponse.setTransmissionDateTime(request.getTransmissionDateTime());
                successResponse.setSystemTraceAuditNumber(request.getSystemTraceAuditNumber());
                successResponse.setLocalTransactionTime(request.getLocalTransactionTime());
                successResponse.setLocalTransactionDate(request.getLocalTransactionDate());
                successResponse.setAcceptingInstitutionCountryCode(request.getAcceptingInstitutionCountryCode());
                successResponse.setPosEntryModeCode(request.getPosEntryModeCode());
                successResponse.setPosConditionCode(request.getPosConditionCode());
                successResponse.setAcceptingInstitutionId(request.getAcceptingInstitutionId());
                successResponse.setRetrievalReferenceNumber(request.getRetrievalReferenceNumber());
                successResponse.setCardAcceptorTerminalId(request.getCardAcceptorTerminalId());
                successResponse.setCardAcceptorId(request.getCardAcceptorId());
                successResponse.setCardAcceptorNameLocation(request.getCardAcceptorNameLocation());
                successResponse.setAdditionalDataPrivate(request.getAdditionalDataPrivate());
                successResponse.setTransactionCurrencyCode(request.getTransactionCurrencyCode());
                successResponse.setUserDefinedField(request.getUserDefinedField());
                successResponse.setServiceCode(request.getServiceCode());
                successResponse.setPaymentCode(request.getPaymentCode());
                successResponse.setReceivingInstitutionId(request.getReceivingInstitutionId());
                successResponse.setFromAccountId(request.getFromAccountId());
                successResponse.setToAccountId(request.getToAccountId());
                successResponse.setContentTransfers(request.getContentTransfers());
                successResponse.setCardholderInfo(request.getCardholderInfo());
                successResponse.setRecordData(request.getRecordData());
                successResponse.setAdditionalRecordData(request.getAdditionalRecordData());
                successResponse.setReserved(request.getReserved());
                successResponse.setMessageAuthenticationCode(request.getMessageAuthenticationCode());

                // Các trường không có trong request,
                successResponse.setSettlementDate(LocalDate.now()); 
                successResponse.setSettlementCode(generateSettlementCode());
                successResponse.setTransactionReferenceNumber(generateRandomRefNumber());
                successResponse.setBeneficialCardHolder("nguyen ba hiep");
                return successResponse;

            case 1:
                return new NapasResponse("05");

            case 2:
                return new NapasResponse("68");

            default:
                try {
                    Thread.sleep(5000); // Giả lập không phản hồi
                } catch (InterruptedException ignored) {}
                return null;
        }
    }

    // Hàm giả lập tạo AuthorizationIdResponse
    private String generateSettlementCode() {
        return String.format("%06d", new Random().nextInt(1000000));
    }

    // Hàm giả lập tạo TransactionReferenceNumber (thay RetrievalReferenceNumber trước đó)
    private String generateRandomRefNumber() {
        return String.format("%012d", new Random().nextInt(1000000000));
    }
}