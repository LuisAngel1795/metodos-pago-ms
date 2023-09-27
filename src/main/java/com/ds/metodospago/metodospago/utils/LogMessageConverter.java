package com.ds.metodospago.metodospago.utils;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.ds.metodospago.metodospago.constants.Constantes;

public class LogMessageConverter {
    public String convert(ILoggingEvent event) {
        return event.getFormattedMessage()
                .replaceAll(Constantes.REGEX_ERROR.toString(), "Fallo")
                .replaceAll(Constantes.REGEX_WARNING.toString(), "Advertencia")
                .replaceAll(Constantes.REGEX_WARN.toString(), "Advertencia")
                .replaceAll(Constantes.REGEX_SEVERE.toString(), "Severo")
                .replaceAll(Constantes.REGEX_EXCEPTION.toString(), "EventoExclusion");
    }
}
