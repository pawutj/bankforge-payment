package com.bankforge.payment.proxy.qrgenerate;

import com.bankforge.payment.model.qrgenerate.QrGenerateRequest;
import com.bankforge.payment.model.qrgenerate.QrGenerateResponse;
import com.bankforge.payment.util.ObjectMapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class QrGenerateProxy {
    private final WebClient webClient;
    private final ObjectMapperUtils objectMapperUtils;

    public QrGenerateProxy(ObjectMapperUtils mapperUtils, WebClient webClient) {
        this.objectMapperUtils = mapperUtils;
        this.webClient = webClient;
    }

    public Mono<QrGenerateResponse> generateQr(QrGenerateRequest generateRequest) {
        return makeRequest(
                this.webClient,
                "",
                generateRequest,
                QrGenerateResponse.class
        );
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
