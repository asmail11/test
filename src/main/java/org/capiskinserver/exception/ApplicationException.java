package org.capiskinserver.exception;

import java.util.Map;

public abstract class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Map<String, String> errorMsgParameters;

    public ApplicationException() {
        super();
    }

    public ApplicationException(Throwable throwable) {
        super(throwable);
    }

    public ApplicationException(String s) {
        super(s);
    }

    public ApplicationException(String s, Map<String, String> errorMsgParameters) {
        super(s);
        this.errorMsgParameters = errorMsgParameters;
    }

    public ApplicationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Map<String, String> getErrorMsgParameters() {
        return errorMsgParameters;
    }

    public void setErrorMsgParameters(Map<String, String> errorMsgParameters) {
        this.errorMsgParameters = errorMsgParameters;
    }
}