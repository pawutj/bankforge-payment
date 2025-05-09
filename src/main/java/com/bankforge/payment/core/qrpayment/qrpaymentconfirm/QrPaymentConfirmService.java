package com.bankforge.payment.core.qrpayment.qrpaymentconfirm;

import com.bankforge.payment.model.qrpaymentrequest.QrPaymentRequestRequest;
import com.bankforge.payment.model.qrpaymentrequest.QrPaymentRequestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QrPaymentConfirmService {

    public Mono<QrPaymentRequestResponse> confirm(
        HttpHeaders httpHeaders,
        QrPaymentRequestRequest request
    ) {
        QrPaymentRequestResponse qrPaymentRequestResponse = QrPaymentRequestResponse.builder().build();
        return Mono.just(qrPaymentRequestResponse);
    }

}
