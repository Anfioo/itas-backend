package com.itas.itasbackend.core;

/**
 * 异常提示信息常量
 */
public class ErrorMessages {

    // === 英文提示（返回前端的 message） ===
    public static final String RUNTIME_EXCEPTION = "System runtime error";
    public static final String DATABASE_ERROR = "Database error";
    public static final String VALIDATION_FAILED = "Validation failed";
    public static final String BINDING_FAILED = "Parameter binding failed";
    public static final String METHOD_NOT_SUPPORTED = "Request method not supported";
    public static final String MESSAGE_NOT_READABLE = "Invalid request body";
    public static final String UNKNOWN_ERROR = "Unexpected error occurred";

    // === 对应的中文提示（返回给 exception_detail） ===
    public static final String CN_RUNTIME_EXCEPTION = "系统运行异常";
    public static final String CN_DATABASE_ERROR = "数据库错误";
    public static final String CN_VALIDATION_FAILED = "参数验证失败";
    public static final String CN_BINDING_FAILED = "参数绑定失败";
    public static final String CN_METHOD_NOT_SUPPORTED = "请求方式不支持";
    public static final String CN_MESSAGE_NOT_READABLE = "请求体格式错误";
    public static final String CN_UNKNOWN_ERROR = "系统异常，请联系管理员";

    private ErrorMessages() {
    }
}
