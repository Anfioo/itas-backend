package com.itas.itasbackend.util.BaseClass;

import java.io.Serial;
import java.io.Serializable;

/**
 * 全局统一响应体
 *
 * @param <T> 返回数据类型
 */


public class ApiResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 业务状态码，0 表示成功，非 0 表示失败
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 返回的数据主体
     */
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // ==================== 静态工厂方法 ====================

    /**
     * 成功，且无返回数据
     */
    public static <T> ApiResponse<T> ok() {
        return new ApiResponse<>(0, "success", null);
    }

    /**
     * 成功，带返回数据
     */
    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(0, "success", data);
    }

    /**
     * 成功，自定义提示 & 返回数据
     */
    public static <T> ApiResponse<T> ok(String message, T data) {
        return new ApiResponse<>(0, message, data);
    }

    /**
     * 失败，自定义错误码 & 错误信息
     */
    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    /**
     * 失败，使用默认错误码 -1
     */
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(-1, message, null);
    }


    /**
     * 失败，自定义错误信息和数据
     */
    public static <T> ApiResponse<T> error(String message, T data) {
        return new ApiResponse<>(-1, message, data);
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
