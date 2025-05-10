package com.bankforge.payment.core.qrpayment.qrpaymentconfirm;

import com.bankforge.payment.model.qrpaymentrequest.QrPaymentRequestRequest;
import com.bankforge.payment.model.qrpaymentrequest.QrPaymentRequestResponse;
import com.bankforge.payment.model.qrpaymentrequest.QrPaymentRequestState;
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
        return Mono.defer(() -> Mono.just(init(httpHeaders, request)))
                .flatMap(this::validateRequest)
                .flatMap(this::generateQr)
                .flatMap(this::saveTransactionHistory)
                .map(res -> res.getQrPaymentRequestResponse());
    }

    private QrPaymentRequestState init(HttpHeaders httpHeaders, QrPaymentRequestRequest qrPaymentRequestRequest) {
        QrPaymentRequestState state = QrPaymentRequestState
                .builder()
                .build();
        return state;
    }

    private Mono<QrPaymentRequestState> validateRequest(QrPaymentRequestState state) {
        return Mono.just(state);
    }

    private Mono<QrPaymentRequestState> generateQr(QrPaymentRequestState state) {
        return Mono.just(state);
    }

    private Mono<QrPaymentRequestState> saveTransactionHistory(QrPaymentRequestState state) {
        return Mono.just(state);
    }

}
