package com.bankforge.payment.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Component
public class ObjectMapperUtils {
    public final ObjectMapper objectMapper;

    public ObjectMapperUtils(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    public <T> Mono<T> mapStringToObject(String res, Class<T> type) {
        try {
            T object = (T) this.objectMapper.reader().readValue(res, type);
            return Mono.just(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
