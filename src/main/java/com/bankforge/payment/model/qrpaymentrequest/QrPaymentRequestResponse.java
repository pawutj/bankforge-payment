package com.bankforge.payment.model.qrpaymentrequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QrPaymentRequestResponse {
    private String partnerTxnUid;
    private String partnerId;
    private String statusCode;
    private String errorCode;
    private String accountName;
    private String qrCode;
    private List<String> sof;
}
