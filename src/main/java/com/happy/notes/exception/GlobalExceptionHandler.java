package com.happy.notes.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<String> handleNoteNotfound(NoteNotFoundException noteNotFoundException){
    String body = noteNotFoundException.getMessage();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);


    }
}
