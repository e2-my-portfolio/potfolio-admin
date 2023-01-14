package lt.e2.portfolio.admin.exception.handler;

import lombok.extern.slf4j.Slf4j;
import lt.e2.portfolio.admin.exception.FirestoreSaveException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IOException.class)
    void handleIOException(IOException exception) {
        log.error("File not found");
        log.error(exception.getMessage(), exception);
    }

    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    @ExceptionHandler({
            InterruptedException.class,
            ExecutionException.class,
            FirestoreSaveException.class
    })
    void handleFirestoreException() {
        log.error("Firestore execution failed");
    }

}
