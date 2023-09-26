package com.ds.metodospago.metodospago.utils;

import static com.ds.metodospago.metodospago.constants.Constantes.USER;
import static com.ds.metodospago.metodospago.constants.Constantes.ADMIN;

public class Utilidades {


    /**
     * Clean string string.
     *
     * @param cadena the cadena
     * @return the string
     */
    public static String cleanString(String cadena) {
        if(cadena == null){
            return null;
        }
        return cadena.replace('\t', '_').replace('\n', '_').replace('\r', '_');
    }

    public static boolean checkAuthorization() {
        return ADMIN.equals(USER);
    }
}
