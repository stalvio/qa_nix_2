package ua.com.alevel.unit_7_patterns.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Requested worker does not exist"
)
public class WorkerNotFoundException extends RuntimeException {

        public WorkerNotFoundException(String s) {
            super(s);
        }
    }
