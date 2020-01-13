package service.result;


/**
 * @description: resutTest
 * @author:tao
 * @create: 2020-01-09 11:57
 */
public class ServiceResultTest {

    public static void main(String[] args) {
        ServiceResult<String, Integer> serviceResult = new ServiceResultBuilder<String, Integer>()
                .code(123)
                .message("特殊")
                .data("data")
                .isSuccess(true).build();
        System.out.println(serviceResult.isSuccess());
        System.out.println(serviceResult.getCodeMessage());



    }
}
