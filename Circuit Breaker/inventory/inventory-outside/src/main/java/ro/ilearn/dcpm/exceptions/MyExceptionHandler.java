package ro.ilearn.dcpm.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;
import java.util.NoSuchElementException;

@ControllerAdvice
public class MyExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    private final MessageSource messageSource;

    public MyExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ApiErrorResponse handleNoSuchElementException(NoSuchElementException ex, WebRequest webRequest) {
        Locale locale = LocaleContextHolder.getLocale();
        //
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND);
        apiErrorResponse.setMessage(messageSource.getMessage("restapi.notfound.msg", null, locale));
        apiErrorResponse.setDetails(webRequest.getDescription(false));
        //
        logger.error(ex.getMessage(), ex);
        //
        return apiErrorResponse;
    }


}
