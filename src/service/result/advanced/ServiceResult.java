package service.result.advanced;

import java.io.Serializable;

/**
 * @description: serivce之间的结果返回（复杂的）
 * @author:tao
 * @create: 2020-01-09 11:45
 */
public class ServiceResult<T, C> implements Serializable {

    public static final CodeMessage<String> SUCCESS = new DefaultMessage<>("00000000", "success");

    private T data;
    private CodeMessage<C> message;
    private boolean isSuccess;

    ServiceResult(T data, boolean isSuccess, CodeMessage<C> message) {
        this.data = data;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public T getData() {
        return data;
    }

    public CodeMessage<C> getCodeMessage() {
        return message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public static <D, C> ServiceResultBuilder<D, C> success() {
        ServiceResultBuilder<D, C> builder = builder();
        return builder.isSuccess(true);
    }

    public static <D, C> ServiceResultBuilder<D, C> success(CodeMessage<C> codeMessage) {
        ServiceResultBuilder<D, C> builder = builder();
        return builder.isSuccess(true).code(codeMessage.getCode()).message(codeMessage.getMessage());
    }

    public static <D> ServiceResult<D, String> success(D data) {
        ServiceResultBuilder<D, String> success = success(SUCCESS);
        return success.data(data).build();
    }

    public static <D, C> ServiceResult<D, C> error(CodeMessage<C> codeMessage) {
        ServiceResultBuilder<D, C> builder = builder();
        return builder.isSuccess(false).code(codeMessage.getCode()).message(codeMessage.getMessage()).build();
    }

    public static <D, C> ServiceResultBuilder<D, C> error() {
        ServiceResultBuilder<D, C> builder = builder();
        return builder.isSuccess(false);
    }


    static <D, C> ServiceResultBuilder<D, C> builder() {
        return new ServiceResultBuilder<>();
    }

    public static class DefaultMessage<C> implements CodeMessage<C>, java.io.Serializable {

        private C code;
        private String message;

        public DefaultMessage(C code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public C getCode() {
            return code;
        }

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return "DefaultMessage{" +
                    "code=" + code +
                    ", message='" + message + '\'' +
                    '}';
        }
    }



    @Override
    public String toString() {
        return "ServiceResult{" +
                "data=" + data +
                ", message=" + message +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
