package service.result.advanced;

import java.util.Objects;

/**
 * @description: ServiceResultBuilder
 * @author:tao
 * @create: 2020-01-09 11:58
 */

public class ServiceResultBuilder<T, C> {

    private T data;
    private C code;
    private String message;
    private boolean isSuccess;

    ServiceResultBuilder() { //package private
    }

    public ServiceResultBuilder<T, C> data(T data) {
        this.data = data;
        return this;
    }

    public ServiceResultBuilder<T, C> isSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public ServiceResultBuilder<T, C> code(C code) {
        this.code = code;
        return this;
    }

    public ServiceResultBuilder<T, C> message(String message) {
        this.message = message;
        return this;
    }

    public ServiceResult<T, C> build() {
        Objects.requireNonNull(code, "code");
        Objects.requireNonNull(code, "message");
        return new ServiceResult<>(data, isSuccess, new ServiceResult.DefaultMessage<>(code, message));
    }
}
