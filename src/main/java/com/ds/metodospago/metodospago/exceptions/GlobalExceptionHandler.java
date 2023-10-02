package com.ds.metodospago.metodospago.exceptions;

import com.ds.metodospago.metodospago.config.TraceFilter;
import com.ds.metodospago.metodospago.constants.Constantes;
import com.ds.metodospago.metodospago.models.RespuestaExcepcionesDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Collections;




@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler{

    private final String proyecto;
    public GlobalExceptionHandler(@Value("${spring.application.name}") String proyecto) {
        this.proyecto = proyecto;
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(MissingRequestHeaderException ex) {
        return buildBadRequest("004001",ex);
    }




    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(MissingServletRequestParameterException ex) {
        return buildBadRequest("004002", ex);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(HttpMessageNotReadableException ex) {
        return buildBadRequest("004003", ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(Exception ex) {
        return buildServerError("005000", ex);
    }
    /*@ExceptionHandler(RemoteServiceException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(RemoteServiceException ex) {
        ErrorCode errorCode = ex.getErrorCode();
        ResponseEntity<RespuestaExcepcionesDto> response;
        String[] codeDetail = ex.getApiError().getCodigo().split(Constantes.SPLIT_REGEX_API_ERROR_CODE.toString());

        String code = codeDetail[codeDetail.length - 1];
        switch (errorCode){
            case E400:
                response = buildBadRequest(code, ex);
                break;
            case E401:
                response = buildUnauthorizedException(code, ex);
                break;
            case E404:
                response = buildNotFoundException(code, ex);
                break;
            case E500:
                response = buildServerError(code, ex);
                break;
            default:
                response = buildServerError("00500", ex);
        }
        return response;
    }*/

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(MethodArgumentTypeMismatchException ex) {
        return buildBadRequest("004004", ex);
    }


    /*@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(ConstraintViolationException ex) {
        if (ex.getConstraintViolations()
                .iterator().next()
                .getConstraintDescriptor().getAnnotation().annotationType() == NoExpirado.class){
            return buildUnauthorizedException("04011", ex);
        }
        return buildBadRequest("04005", ex);
    }*/


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(MethodArgumentNotValidException ex) {
        return buildBadRequest("004006", ex);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(HttpRequestMethodNotSupportedException ex) {
        return buildBadRequest("004006", ex);
    }


    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(HttpMediaTypeNotSupportedException ex) {
        return buildBadRequest("004007", ex);
    }
    @ExceptionHandler(ServerInternalException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(ServerInternalException ex) {
        return buildServerError("5001", ex);
    }

    @ExceptionHandler(MetodosPagoException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(MetodosPagoException ex) {
        return buildServerError("5002", ex);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(DataNotFoundException ex) {
        return buildNotFoundException("4041", ex);
    }

    @ExceptionHandler(CampoInvalido.class)
    public ResponseEntity<RespuestaExcepcionesDto> mapException(CampoInvalido ex) {
        return buildBadRequest("4008", ex);
    }
    /*public ResponseEntity<RespuestaExcepcionesDto> buildUnauthorizedException(String codigoExcepcion, Exception ex){
        RespuestaExcepcionesDto errorResponse = new RespuestaExcepcionesDto();
        String codigoError = String.valueOf(HttpStatus.UNAUTHORIZED.value());

        errorResponse.setCodigo(
                String.format(Constantes.CODIGO_TEMPLATE, codigoError, codigoExcepcion)
        );
        errorResponse.setMensaje(Constantes.MENSAJE401);
        errorResponse.setFolio(
                String.format(Constantes.EXCEPTION, this.proyecto, MDC.get(TraceFilter.TRACE_ID))
        );
        errorResponse.setInfo(
                String.format(Constantes.INFO_TEMPLATE, codigoError, codigoExcepcion)
        );

        log.error(ExceptionUtils.getStackTrace(ex));

        errorResponse.setDetalles(Collections.singletonList(Constantes.MENSAJE401));

        // Response
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }*/


    public ResponseEntity<RespuestaExcepcionesDto> buildNotFoundException(String codigoExcepcion, Exception ex){
        RespuestaExcepcionesDto errorResponse = new RespuestaExcepcionesDto();
        String codigoError = String.valueOf(HttpStatus.NOT_FOUND.value());

        errorResponse.setCodigo(
                String.format(codigoError, codigoExcepcion)
        );
        errorResponse.setMensaje(Constantes.MENSAJE404);
        errorResponse.setFolio(String.format(Constantes.EXCEPTION,  this.proyecto, MDC.get(TraceFilter.TRACE_ID))
        );
        errorResponse.setInfo(String.format(Constantes.INFO_TEMPLATE,codigoError, codigoExcepcion)
        );

        errorResponse.setDetalles(Collections.singletonList(ex.getMessage()));

        // Response
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    public ResponseEntity<RespuestaExcepcionesDto> buildBadRequest(String codigoExcepcion, Exception ex){
        RespuestaExcepcionesDto errorResponse = new RespuestaExcepcionesDto();
        String codigoError = String.valueOf(HttpStatus.BAD_REQUEST.value());

        errorResponse.setCodigo(
                String.format( codigoError, codigoExcepcion)
        );
        errorResponse.setMensaje(Constantes.MENSAJE400);
        errorResponse.setFolio(String.format(Constantes.EXCEPTION,  this.proyecto, MDC.get(TraceFilter.TRACE_ID))
        );
        errorResponse.setInfo(String.format( Constantes.INFO_TEMPLATE,codigoError, codigoExcepcion)
        );

        errorResponse.setDetalles(Collections.singletonList(ex.getMessage()));

        // Response
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    public ResponseEntity<RespuestaExcepcionesDto> buildServerError(String codigoExcepcion, Exception ex){
        RespuestaExcepcionesDto errorResponse = new RespuestaExcepcionesDto();
        String codigoError = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());

        errorResponse.setCodigo(
                String.format(codigoError, codigoExcepcion)
        );
        errorResponse.setMensaje(Constantes.MENSAJE500);
        errorResponse.setFolio(String.format(Constantes.EXCEPTION,  this.proyecto, MDC.get(TraceFilter.TRACE_ID))
        );
        errorResponse.setInfo(String.format(Constantes.INFO_TEMPLATE, codigoError, codigoExcepcion)
        );
        errorResponse.setDetalles(Collections.singletonList(ex.getMessage()));

        // Response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
