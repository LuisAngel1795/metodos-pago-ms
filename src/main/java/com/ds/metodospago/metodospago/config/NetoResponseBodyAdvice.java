package com.ds.metodospago.metodospago.config;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ds.metodospago.metodospago.exceptions.GlobalExceptionHandler;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils;

/**
 * The type Neto response body advice.
 *
 * @author: Felipe Palacios
 * @creación - 19 julio 2022
 * @versión: V1.0.0.1
 * @descripción: Clase encargada de regresar respuesta
 */
@ControllerAdvice
public class NetoResponseBodyAdvice implements ResponseBodyAdvice<Object>{


    /**
     * Nombre del proyecto.
     */
    private String proyecto = "microservice-metodos-pago-v1";


    /**
     * The type Neto response body advice.
     *
     * @param converterType
     * @param returnType
     * @author: Felipe Palacios
     * @creación - 19 julio 2022
     * @versión: V1.0.0.1
     */

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !StringUtils.equalsIgnoreCase(GlobalExceptionHandler.class.getName(),
                returnType.getContainingClass().getName());
    }


    /**
     * The type Neto response body advice.
     *
     * @author: Felipe Palacios
     * @creación - 19 julio 2022
     * @versión: V1.0.0.1
     * @param body
     * @param returnType
     * @param request
     * @param response
     */

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
            Map<String, Object> bodyResponse = new LinkedHashMap<>();
            bodyResponse.put("mensaje", "Operacion exitosa");
            bodyResponse.put("folio", String.format("cld-%s-%s",this.proyecto, MDC.get(TraceFilter.TRACE_ID)));
            bodyResponse.put("resultado", body);
            body = bodyResponse;
        return body;
    }
}
