package ua.com.alevel.unit_7_patterns.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Requested department does not exist"
)
public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException(String s) {
        super(s);
    }
}
