package com.cloud.ccb.context.configuration.exception;

import cn.liberfree.common.ApiErrorResponse;
import cn.liberfree.common.exception.BusinessException;
import feign.FeignException;
import lombok.Getter;
import lombok.Setter;
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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by zhaofujun on 2017/8/28.
 */
@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = {BusinessException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse constraintBusinessException(BusinessException ex) {
        log.error("Business exception, errorCode: {}, errorDesc: {}", ex.getErrorCode(), ex.getMessage());
        return new ApiErrorResponse(ex.getErrorCode(), ex.getClass().getName(), ex.getMessage(), ex);
    }


    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse constraintException(Exception ex) {
        log.error("Unknow exception", ex);
        return new ApiErrorResponse("500",  ex.getClass().getName(),ex.getMessage(), ex);
    }

    @ExceptionHandler(value = {FeignException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse constraintFeignException(Exception ex) {
        log.error("Feign exception", ex);
        return new ApiErrorResponse("500", ex.getClass().getName(),ex.getMessage(), ex);
    }

    /**
     * Handle violation exception
     * 验证异常处理message提示
     *
     * @param ex
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse error(ConstraintViolationException ex) {
        log.error("Params violation excetion", ex);

        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        List<String> errorMsg = new LinkedList<>();
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            for (ConstraintViolation<?> violation : constraintViolations) {
                errorMsg.add(violation.getMessage());
            }
        }
        return new ApiErrorResponse("500", ex.getClass().getName(), ex.getMessage(), ex);
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse error(BindException ex) {
        log.error("Params bind exception", ex);
        List<String> errorMsg = new LinkedList<>();
        for (ObjectError objectError : ex.getAllErrors()) {
            FieldError fieldError = (FieldError) objectError;
            errorMsg.add(fieldError.getField() + fieldError.getDefaultMessage());
        }
        return new ApiErrorResponse("500", ex.getClass().getName(), ex.getMessage(), ex);
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
        String errorMessage = fieldError.getDefaultMessage();
        return new ApiErrorResponse("500", ex.getClass().getName(),errorMessage, ex);
    }

}
