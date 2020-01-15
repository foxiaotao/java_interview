package repay;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description: 还款计划计算公式
 * @author:tao
 * @create: 2020-01-14 11:45
 */
public class Repayment {

    private static final int DECIMAL_POINT_COUNT = 6;


    public static void main(String[] args) {
        System.out.println(needRepay(10000d, 0.36d, 12));
    }

    /**
     *
     * @param principalDouble
     * @param yearInterestRateDouble 年利率
     * @param periods
     * @return
     */
    public static BigDecimal needRepay(Double principalDouble, Double yearInterestRateDouble, int periods) {

        BigDecimal principal = BigDecimal.valueOf(principalDouble);
        BigDecimal yearInterestRate = BigDecimal.valueOf(yearInterestRateDouble);
        BigDecimal mouthRate = yearInterestRate.divide(BigDecimal.valueOf(12), DECIMAL_POINT_COUNT, RoundingMode.HALF_UP);
        // [贷款本金×月利率×（1+月利率）^还款月数]÷[（1+月利率）^还款月数－1]
        BigDecimal pow = BigDecimal.ONE.add(mouthRate).pow(periods);
        return principal.multiply(mouthRate).multiply(pow).divide(pow.subtract(BigDecimal.ONE), DECIMAL_POINT_COUNT, RoundingMode.HALF_UP);
    }
}
