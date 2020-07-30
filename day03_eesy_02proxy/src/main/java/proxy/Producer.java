package proxy;

/**
 * @program: day03_eesy_02proxy
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/28 21:58
 */


public class Producer implements IProducer {
    public void saleProduct(Double money) {
        System.out.println("商品售价:"+money);
    }

    public void afterService(Double money) {
        System.out.println("维护费用:"+money);
    }
}
