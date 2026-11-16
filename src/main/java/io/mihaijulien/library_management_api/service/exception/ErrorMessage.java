package io.mihaijulien.library_management_api.service.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    BOOK_NOT_FOUND("Book not found"),
    MISSING_BOOK("Missing book");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }
}