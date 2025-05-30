package com.itas.itasbackend.core;


import com.itas.itasbackend.util.BaseClass.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<Object> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        log.error("{}：{}", ErrorMessages.CN_RUNTIME_EXCEPTION, e.getMessage(), e);
        return ApiResponse.error(ErrorMessages.RUNTIME_EXCEPTION,
                buildErrorDetail(e, ErrorMessages.CN_RUNTIME_EXCEPTION));
    }

    /**
     * 数据库异常
     */
    @ExceptionHandler(DataAccessException.class)
    public ApiResponse<Object> handleDataAccessException(DataAccessException e) {
        log.error("{}：{}", ErrorMessages.CN_DATABASE_ERROR, e.getMessage(), e);
        return ApiResponse.error(ErrorMessages.DATABASE_ERROR,
                buildErrorDetail(e, ErrorMessages.CN_DATABASE_ERROR));
    }

    /**
     * 请求体校验失败（@Valid/@Validated）
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Object> handleValidationException(MethodArgumentNotValidException e) {
        e.getBindingResult().getFieldError();
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        log.warn("{}：{}", ErrorMessages.CN_VALIDATION_FAILED, message);
        return ApiResponse.error(ErrorMessages.VALIDATION_FAILED,
                buildErrorDetail(e, ErrorMessages.CN_VALIDATION_FAILED));
    }

    /**
     * 表单绑定校验失败（如 form-data）
     */
    @ExceptionHandler(BindException.class)
    public ApiResponse<Object> handleBindException(BindException e) {
        e.getBindingResult().getFieldError();
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        log.warn("{}：{}", ErrorMessages.CN_BINDING_FAILED, message);
        return ApiResponse.error(ErrorMessages.BINDING_FAILED,
                buildErrorDetail(e, ErrorMessages.CN_BINDING_FAILED));
    }

    /**
     * 请求方法不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ApiResponse<Object> handleMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        log.warn("{}：{}", ErrorMessages.CN_METHOD_NOT_SUPPORTED, e.getMessage());
        return ApiResponse.error(ErrorMessages.METHOD_NOT_SUPPORTED,
                buildErrorDetail(e, ErrorMessages.CN_METHOD_NOT_SUPPORTED));
    }

    /**
     * JSON 请求体格式错误
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiResponse<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
        log.warn("{}：{}", ErrorMessages.CN_MESSAGE_NOT_READABLE, e.getMessage());
        return ApiResponse.error(ErrorMessages.MESSAGE_NOT_READABLE,
                buildErrorDetail(e, ErrorMessages.CN_MESSAGE_NOT_READABLE));
    }

    /**
     * 兜底异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleGenericException(Exception e) {
        log.error("{}：{}", ErrorMessages.CN_UNKNOWN_ERROR, e.getMessage(), e);
        return ApiResponse.error(ErrorMessages.UNKNOWN_ERROR,
                buildErrorDetail(e, ErrorMessages.CN_UNKNOWN_ERROR));
    }

    /**
     * 构建异常详细信息
     */
    private Map<String, Object> buildErrorDetail(Exception e, String exceptionDetail) {
        Map<String, Object> detail = new LinkedHashMap<>();
        detail.put("exception", e.getClass().getName());
        detail.put("exception_detail", exceptionDetail);
        detail.put("message", e.getMessage());

        StackTraceElement[] stack = e.getStackTrace();
        if (stack.length > 0) {
            detail.put("at", stack[0].toString());
        }

        return detail;
    }


}
