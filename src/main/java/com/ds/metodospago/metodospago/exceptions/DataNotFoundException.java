package com.ds.metodospago.metodospago.exceptions;

public class DataNotFoundException extends RuntimeException {


    private static final long serialVersionUID = 1170717193345697964L;

    /**
     * Constructor.
     *
     * @param message
     */
    public DataNotFoundException(String message) {
        super(message);
    }
}
