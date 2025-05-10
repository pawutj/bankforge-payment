package com.bankforge.payment.model.qrpaymentrequest;

import com.bankforge.payment.model.qrgenerate.QrGenerateRequest;
import com.bankforge.payment.model.qrgenerate.QrGenerateResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QrPaymentRequestState {
    private QrPaymentRequestRequest qrPaymentRequestRequest;
    private QrPaymentRequestResponse qrPaymentRequestResponse;

    private QrGenerateRequest qrGenerateRequest;
    private QrGenerateResponse qrGenerateResponse;
}
