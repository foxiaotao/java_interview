package service.result;

/**
 * @description:
 * @author:tao
 * @create: 2020-01-09 11:48
 */
public interface CodeMessage<C> {

    C getCode();

    String getMessage();
}
