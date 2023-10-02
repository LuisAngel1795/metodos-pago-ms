package com.ds.metodospago.metodospago.constants;

import java.util.regex.Pattern;

public class Constantes {

    public static final String MENSAJE404 = "Información no encontrada.";
    public static final String MENSAJE401 = "No estas autorizado, favor de validar";
    public static final String EXCEPTION = "cld-%s-%s";
    public static final String MENSAJE400 = "Solicitud mal formada, favor de validar.";
    public static final String MENSAJE500 = "Problemas al procesar su solicitud, favor de contactar a su administrador.";
    public static final String KEYAPI = "api";
    public static final String API = "Neto-Carrito-Compras-Gestion-Productos";
    public static final String TIEMPO_TOTAL = "tiempoTotal";

    public static final String INFO_TEMPLATE =
            "https://www.tiendita.com.mx/info#%s.Tiendita-Cld-Metodos-Pago.%s";

    // constante USER
    public static final String USER = "admin";

    // constante ADMIN
    public static final String ADMIN = "admin";

    public static final Pattern REGEX_ERROR = Pattern.compile("(?i)ERROR");

    public static final Pattern REGEX_WARNING = Pattern.compile("(?i)WARNING");

    public static final Pattern REGEX_WARN = Pattern.compile("(?i)WARN");

    public static final Pattern REGEX_SEVERE = Pattern.compile("(?i)SEVERE");

    public static final Pattern REGEX_EXCEPTION = Pattern.compile("(?i)EXCEPTION");
}
