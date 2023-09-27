package com.ds.metodospago.metodospago.controller;

import com.ds.metodospago.metodospago.config.TraceFilter;
import com.ds.metodospago.metodospago.constants.Constantes;
import com.ds.metodospago.metodospago.models.RespuestaExcepcionesDto;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@Controller
public class RequestMappgingErrorController extends AbstractErrorController {

    private final String proyecto;
    public static HttpServletRequest requ;

    public RequestMappgingErrorController(ErrorAttributes errorAttributes, @Value("${spring.application.name}") String proyecto) {
        super(errorAttributes);
        this.proyecto = proyecto;
    }

    @RequestMapping("/error")
    public ResponseEntity<RespuestaExcepcionesDto> handle404(HttpServletRequest request) {
        RequestMappgingErrorController.requ = request;
        Map<String, Object> errorAttributes = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        HttpStatus status = getStatus(request);
        String mensaje = "Recurso no encontrado: " + errorAttributes.get("path");
        return buildNotFoundException("4041");
    }

    public ResponseEntity<RespuestaExcepcionesDto> buildNotFoundException(String codigoExcepcion){
        RespuestaExcepcionesDto errorResponse = new RespuestaExcepcionesDto();
        String codigoError = String.valueOf(HttpStatus.NOT_FOUND.value());
        errorResponse.setCodigo(String.format(codigoError, codigoExcepcion));
        errorResponse.setMensaje(Constantes.MENSAJE404);
        errorResponse.setFolio(String.format(Constantes.EXCEPTION,  this.proyecto, MDC.get(TraceFilter.TRACE_ID)));
        errorResponse.setInfo(String.format(Constantes.INFO_TEMPLATE, codigoError ,Constantes.MENSAJE404));
        errorResponse.setDetalles(Collections.singletonList(Constantes.MENSAJE404));
        // Response
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
