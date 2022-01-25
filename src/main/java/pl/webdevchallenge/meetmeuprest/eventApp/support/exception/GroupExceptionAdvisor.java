package pl.webdevchallenge.meetmeuprest.eventApp.support.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.webdevchallenge.meetmeuprest.shared.api.response.ErrorMessageResponse;

@ControllerAdvice
public class GroupExceptionAdvisor {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(GroupExceptionAdvisor.class);

    @ExceptionHandler(GroupNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse groupNotFound(GroupNotFoundException exception) {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getLocalizedMessage());
    }
}
