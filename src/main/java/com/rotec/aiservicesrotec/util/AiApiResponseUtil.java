package com.rotec.aiservicesrotec.util;


import com.rotec.aiservicesrotec.response.AiApiResponse;

public class AiApiResponseUtil {
    private static final Integer SUCCESS_CODE = 200;
    private static final Integer ERROR_CODE = 500;
    private static final String SUCCESS_MESSAGE = "操作成功";
    private static final String ERROR_MESSAGE = "操作失败";

    // 成功响应，带数据
    public static <T> AiApiResponse<T> success(T data) {
        return AiApiResponse.<T>builder()
                .code(SUCCESS_CODE)
                .message(SUCCESS_MESSAGE)
                .data(data)
                .build();
    }

    // 成功响应，带消息和数据
    public static <T> AiApiResponse<T> success(String message, T data) {
        return AiApiResponse.<T>builder()
                .code(SUCCESS_CODE)
                .message(message)
                .data(data)
                .build();
    }

    // 成功响应，不带数据
    public static <T> AiApiResponse<T> success() {
        return success(null);
    }

    // 错误响应，带消息
    public static <T> AiApiResponse<T> error(String message) {
        return AiApiResponse.<T>builder()
                .code(ERROR_CODE)
                .message(message)
                .build();
    }

    // 错误响应，带错误码和消息
    public static <T> AiApiResponse<T> error(int code, String message) {
        return AiApiResponse.<T>builder()
                .code(code)
                .message(message)
                .build();
    }

    // 从通用异常创建错误响应
    public static <T> AiApiResponse<T> error(Exception e) {
        return AiApiResponse.<T>builder()
                .code(ERROR_CODE)
                .message(e.getMessage())
                .build();
    }

    // 判断响应是否成功
    public static boolean isSuccess(AiApiResponse<?> response) {
        return response != null && response.getCode() == SUCCESS_CODE;
    }

    // 创建支付相关的错误响应
    public static <T> AiApiResponse<T> paymentError(String operation, String message) {
        return error(String.format("%s失败: %s", operation, message));
    }

    // 创建支付相关的成功响应
    public static <T> AiApiResponse<T> paymentSuccess(String operation, T data) {
        return success(String.format("%s成功", operation), data);
    }
}
