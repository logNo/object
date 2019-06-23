package com.example.object;

// ticket 이 없으면, 시스템 중지 ?
public class SoldOutException extends Exception {

    public SoldOutException() {
    }

    public SoldOutException(String message) {
        super(message);
    }

    public SoldOutException(String message, Throwable cause) {
        super(message, cause);
    }
}
