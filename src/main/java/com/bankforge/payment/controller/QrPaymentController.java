package com.bankforge.payment.controller;

import com.bankforge.payment.core.qrpayment.qrpaymentconfirm.QrPaymentConfirmService;
import com.bankforge.payment.model.qrpaymentrequest.QrPaymentRequestRequest;
import com.bankforge.payment.model.qrpaymentrequest.QrPaymentRequestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping("/v1/qrpayment/")
@RestController("qrPaymentController")
public class QrPaymentController {

    private final QrPaymentConfirmService qrPaymentConfirmService;

    @PostMapping("request")
    public Mono<ResponseEntity<QrPaymentRequestResponse>> request(
            @RequestHeader HttpHeaders httpHeaders,
            @RequestBody QrPaymentRequestRequest request) {

            return qrPaymentConfirmService.confirm(httpHeaders,request)
                    .map(ResponseEntity::ok);

    }


}
