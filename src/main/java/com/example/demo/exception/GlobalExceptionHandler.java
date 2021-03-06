package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//TODO GTB：404的Exception是否可以统一成一个？
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TraineeNotExistException.class)
    public ResponseEntity<ErrorResult> handleTraineeNotExistException(TraineeNotExistException e) {
        ErrorResult errorResult = new ErrorResult(404,"Not Found",e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(TrainerNotExistException.class)
    public ResponseEntity<ErrorResult> handleTrainerNotExistException(TrainerNotExistException e) {
        ErrorResult errorResult = new ErrorResult(404,"Not Found",e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(CannotDivideException.class)
    public ResponseEntity<ErrorResult> handleCannotDivideException(CannotDivideException e) {
        ErrorResult errorResult = new ErrorResult(400,"Bad Request",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(GroupNotExistException.class)
    public ResponseEntity<ErrorResult> handleGroupNotExistException(GroupNotExistException e) {
        ErrorResult errorResult = new ErrorResult(404,"Bad Request",e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(400, "Bad Request", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
