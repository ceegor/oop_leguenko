package ru.vsu.cs.leguenko_e_yu.exception;

public enum ErrorType {
    INVALID_INPUT("Invalid input provided"),
    NULL_VALUE("Null value encountered"),
    OUT_OF_RANGE("Value is out of range"),
    FILE_NOT_FOUND("File not found"),
    IO_ERROR("I/O operation failed"),
    NETWORK_ERROR("Network connection error"),
    CONNECTION_TIMEOUT("Connection timed out"),
    PERMISSION_DENIED("Permission denied"),
    DB_CONNECTION_FAILED("Database connection failed"),
    SQL_SYNTAX_ERROR("SQL syntax error"),
    OUT_OF_MEMORY("Out of memory"),
    STACK_OVERFLOW("Stack overflow error"),
    ARITHMETIC_ERROR("Arithmetic operation error"),
    INDEX_OUT_OF_BOUNDS("Index out of bounds"),
    THREAD_INTERRUPTED("Thread was interrupted"),
    UNKNOWN_ERROR("An unknown error occurred");
    private final String description;

    ErrorType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
