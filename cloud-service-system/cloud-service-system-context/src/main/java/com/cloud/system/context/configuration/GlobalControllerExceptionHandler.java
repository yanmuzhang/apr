package com.cloud.system.context.configuration;

import com.cloud.common.ApiErrorResponse;
import com.cloud.common.execption.BusinessExecption;
import com.cloud.common.execption.ExceptionEnum;
import com.cloud.ddd.core.DDDExecption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by zhaofujun on 2017/8/28.
 */
@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = {BusinessExecption.class,DDDExecption.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse constraintSystemException(RuntimeException ex) {
        log.error("System exception, errorDesc: {}", ex.getCause().getMessage());
        ex.printStackTrace();
        return new ApiErrorResponse(500, ex.getMessage(), ex);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse constraintException(Exception ex) {
        log.error("Unknow exception", ex);
        return new ApiErrorResponse(500, ex.getMessage(), ex);
    }

    /**
     * Handle violation exception
     * 验证异常处理message提示
     *
     * @param cve
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse error(ConstraintViolationException cve) {
        log.error("Params violation excetion", cve);

        Set<ConstraintViolation<?>> constraintViolations = cve.getConstraintViolations();
        List<String> errorMsg = new LinkedList<>();
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            for (ConstraintViolation<?> violation : constraintViolations) {
                errorMsg.add(violation.getMessage());
            }
        }
        return new ApiErrorResponse(ExceptionEnum.INVALID_PARAMS.getCode(), errorMsg.toString(), cve);
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse error(BindException bindException) {
        log.error("Params bind exception", bindException);
        List<String> errorMsg = new LinkedList<>();
        for (ObjectError objectError : bindException.getAllErrors()) {
            FieldError fieldError = (FieldError) objectError;
            errorMsg.add(fieldError.getField() + fieldError.getDefaultMessage());
        }
        return new ApiErrorResponse(ExceptionEnum.INVALID_PARAMS.getCode(), errorMsg.toString(), bindException);
    }

    /**
     * @param ex
     * @return
     * @RequestBody json数据接收绑定异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String errorMessage = fieldError.getField() + fieldError.getDefaultMessage();
        return new ApiErrorResponse(ExceptionEnum.INVALID_PARAMS.getCode(), errorMessage, ex);
    }

}
