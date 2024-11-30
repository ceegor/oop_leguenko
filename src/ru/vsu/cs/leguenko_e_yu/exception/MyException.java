package ru.vsu.cs.leguenko_e_yu.exception;

public class MyException extends Exception {

    private final ErrorType errorType;

    public MyException(ErrorType errorType) {
        super(errorType.getDescription());
        this.errorType = errorType;
    }
    public MyException(ErrorType errorType, Throwable cause) {
        super(errorType.getDescription(), cause);
        this.errorType = errorType;
    }
    public ErrorType getErrorType() {
        return errorType;
    }
    
    @Override
    public String toString() {
        return "MyException{" +
                "errorType=" + errorType +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}
