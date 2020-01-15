package service.result.simple;


import java.io.Serializable;

/**
 * @description: serivce之间的结果返回（简单的）
 * @author:tao
 * @create: 2020-01-09 11:45
 */
public class ServiceResult<T> implements Serializable {

    public static final String SUCCESS_MESSAGE = "success";
    public static final String SUCCESS_CODE = "0000";


    private T data;
    private String message;
    private String code;
    private boolean isSuccess;

    ServiceResult(T data, boolean isSuccess, String message, String code) {
        this.data = data;
        this.message = message;
        this.code = code;
        this.isSuccess = isSuccess;
    }


    @SuppressWarnings("unchecked")
    public static ServiceResult fail(String message, String code) {
        return new ServiceResult(null, false, message, code);
    }

    @SuppressWarnings("unchecked")
    public static<T> ServiceResult<T> failData(String message, String code, T data) {
        return new ServiceResult(data, false, message, code);
    }

    @SuppressWarnings("unchecked")
    public static<T> ServiceResult<T> success(T data) {
        return new ServiceResult(data, true, SUCCESS_MESSAGE, SUCCESS_CODE);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
