/*
 * package letapp.dev.mokayada.exeptions;
 * 
 * import java.util.Date;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.context.request.WebRequest; import
 * org.springframework.web.servlet.mvc.method.annotation.
 * ResponseEntityExceptionHandler;
 * 
 * import letapp.dev.mokayada.responses.ErrorMessage;
 * 
 * @ControllerAdvice public class AppExceptionHandler extends
 * ResponseEntityExceptionHandler {
 * 
 * @ExceptionHandler(value = {Exception.class}) public ResponseEntity<Object>
 * handelAnyException(Exception ex,WebRequest request){ String
 * errorMessageDescription = ex.getMessage(); if(errorMessageDescription ==
 * null) errorMessageDescription = "Erreur Technique"; ErrorMessage errorMessage
 * = new ErrorMessage(new Date(),errorMessageDescription); return new
 * ResponseEntity<Object>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
 * 
 * }
 * 
 * }
 */