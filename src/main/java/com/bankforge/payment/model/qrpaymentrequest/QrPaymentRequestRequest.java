package com.bankforge.payment.model.qrpaymentrequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QrPaymentRequestRequest {
    private String partnerTxUid;
    private String partnerId;
    private String partnerSecret;
    private String requestDt;
    private String qrType;
    private String txnAmount;
    private String txnCurrencyCode;
    private String reference1;
    private String reference2;
    private String reference3;
    private String reference4;
    private String metadata;
}
