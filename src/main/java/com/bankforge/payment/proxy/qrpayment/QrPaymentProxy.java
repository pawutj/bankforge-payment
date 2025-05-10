package com.bankforge.payment.proxy.qrpayment;

import com.bankforge.payment.util.ObjectMapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class QrPaymentProxy {
    private final WebClient webClient;
    private final ObjectMapperUtils objectMapperUtils;

    public QrPaymentProxy(ObjectMapperUtils mapperUtils, WebClient webClient) {
        this.objectMapperUtils = mapperUtils;
        this.webClient = webClient;
    }

    private <TRequest, TResponse> Mono<TResponse> makeRequest(
            WebClient webClient,
            String path,
            TRequest request,
            Class<TResponse> responseType) {
        return webClient
                .post()
                .uri(path)
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(res -> objectMapperUtils.mapStringToObject(res, responseType));
    }

}
