package com.ds.metodospago.metodospago.exceptions;

public class MetodosPagoException extends RuntimeException{
    /**
 * Serialización.
 */

private static final long serialVersionUID = -1736093933644723513L;



    /**
     * Constructor.
     *
     * @param message
     */
    public MetodosPagoException(String message) {
        super(message);
    }
}
