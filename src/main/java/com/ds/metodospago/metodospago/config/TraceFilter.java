package com.ds.metodospago.metodospago.config;

import com.ds.metodospago.metodospago.utils.Utilidades;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import static com.ds.metodospago.metodospago.constants.Constantes.API;
import static com.ds.metodospago.metodospago.constants.Constantes.KEYAPI;
import static com.ds.metodospago.metodospago.constants.Constantes.TIEMPO_TOTAL;


@Component
@Slf4j
public class TraceFilter implements Filter {
    public static final String TRACE_ID = "traceId";
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        long tiempoInicio = System.currentTimeMillis();
        String folio = UUID.randomUUID().toString().replace("-", StringUtils.EMPTY);
        MDC.put(TraceFilter.TRACE_ID, folio.toUpperCase(Locale.ENGLISH));
        MDC.put(KEYAPI, API);
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.info("Inicia Peticion. uri={}", Utilidades.cleanString(httpServletRequest.getRequestURI()));
        chain.doFilter(request, response);
        MDC.put(TIEMPO_TOTAL, String.valueOf((System.currentTimeMillis() - tiempoInicio)));
        log.info("Termina Peticion. uri={}", Utilidades.cleanString(httpServletRequest.getRequestURI()));
        MDC.remove(TIEMPO_TOTAL);

    }
}
