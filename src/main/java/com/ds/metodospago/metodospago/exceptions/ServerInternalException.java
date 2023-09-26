package com.ds.metodospago.metodospago.exceptions;

public class ServerInternalException extends RuntimeException{


    private static final long serialVersionUID = 1293083427276296986L;

    /**
     * Constructor.
     *
     * @param message message
     */
    public ServerInternalException(String message) {
        super(message);
    }
}
