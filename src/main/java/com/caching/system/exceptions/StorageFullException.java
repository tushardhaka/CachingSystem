package com.caching.system.exceptions;

public class StorageFullException extends RuntimeException{

    public StorageFullException(String message){
        super(message);
    }
}
