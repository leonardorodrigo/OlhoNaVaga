package br.com.olhonavaga.service;

/**
 * Created with IntelliJ IDEA.
 * User: Leonardo Neves
 * Date: 14/12/2015
 * Time: 09:57
 */
public class VagaException extends Exception {

    public VagaException() {
    }

    public VagaException(String detailMessage) {
        super(detailMessage);
    }

    public VagaException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public VagaException(Throwable throwable) {
        super(throwable);
    }
}
