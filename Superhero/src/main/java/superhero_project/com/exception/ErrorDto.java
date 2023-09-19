package superhero_project.com.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Getter
@Setter

public class ErrorDto {
    private String errorMessage;
    private HttpStatus errorCode;
    private LocalDateTime errorDateTime;

    public ErrorDto(String errorMessage, HttpStatus internalServerError, LocalDateTime errorDateTime) {
        super();
        this.errorMessage = errorMessage;
        this.errorCode = internalServerError;
        this.errorDateTime = errorDateTime;
    }


    @Override
    public String toString() {
        return "ErrorDto [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", errorDateTime="
                + errorDateTime + "]";
    }

}
