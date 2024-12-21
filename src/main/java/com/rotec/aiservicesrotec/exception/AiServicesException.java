package com.rotec.aiservicesrotec.exception;


import com.rotec.aiservicesrotec.enums.AiServicesErrorCode;

public class AiServicesException extends RuntimeException {
    private final int code;
    
    public AiServicesException(String message) {
        super(message);
        this.code = AiServicesErrorCode.PAYMENT_ERROR.getCode();
    }
    
    public AiServicesException(int code, String message) {
        super(message);
        this.code = code;
    }
    
    public AiServicesException(String message, Throwable cause) {
        super(message, cause);
        this.code = AiServicesErrorCode.PAYMENT_ERROR.getCode();
    }
    
    public AiServicesException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    // 便捷的静态工厂方法
    public static AiServicesException paymentCancelled() {
        return AiServicesErrorCode.PAYMENT_CANCELLED.toException();
    }

    public static AiServicesException paymentExpired() {
        return AiServicesErrorCode.PAYMENT_EXPIRED.toException();
    }

    public static AiServicesException paymentDeclined() {
        return AiServicesErrorCode.PAYMENT_DECLINED.toException();
    }

    public static AiServicesException invalidPaymentMethod() {
        return AiServicesErrorCode.INVALID_PAYMENT_METHOD.toException();
    }

    public static AiServicesException insufficientFunds() {
        return AiServicesErrorCode.INSUFFICIENT_FUNDS.toException();
    }

    public static AiServicesException paymentAlreadyProcessed() {
        return AiServicesErrorCode.PAYMENT_ALREADY_PROCESSED.toException();
    }

    public static AiServicesException invalidCurrency() {
        return AiServicesErrorCode.INVALID_CURRENCY.toException();
    }

    public static AiServicesException invalidAmount() {
        return AiServicesErrorCode.INVALID_AMOUNT.toException();
    }

    public static AiServicesException stripeApiError(String detail) {
        return AiServicesErrorCode.STRIPE_API_ERROR.toException(detail);
    }

    public static AiServicesException webhookVerificationFailed() {
        return AiServicesErrorCode.WEBHOOK_VERIFICATION_FAILED.toException();
    }
    
    public int getCode() {
        return code;
    }
} 