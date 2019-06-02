package weather_service.exception;

/**
 * Exception class for form validation.
 */
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
