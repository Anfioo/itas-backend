package com.itas.itasbackend.util.BaseClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 返回成功（无数据）
     */
    public <T> ApiResponse<T> success() {
        return ApiResponse.ok();
    }

    /**
     * 返回成功（带数据）
     */
    public <T> ApiResponse<T> success(T data) {
        return ApiResponse.ok(data);
    }

    /**
     * 返回成功（自定义消息 + 数据）
     */
    public <T> ApiResponse<T> success(String message, T data) {
        return ApiResponse.ok(message, data);
    }

    /**
     * 返回失败（默认 -1）
     */
    public <T> ApiResponse<T> error(String message) {
        return ApiResponse.error(message);
    }

    /**
     * 返回失败（指定 code）
     */
    public <T> ApiResponse<T> error(int code, String message) {
        return ApiResponse.error(code, message);
    }


    /**
     * 快捷返回布尔状态结果
     */
    public <T> ApiResponse<T> toResult(boolean success) {
        return success ? success() : error("操作失败");
    }
}
