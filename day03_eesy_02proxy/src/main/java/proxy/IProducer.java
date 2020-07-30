package proxy;

/**
 * @program: day03_eesy_02proxy
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/28 21:56
 */


public interface IProducer {
    /**
     * 销售上篇
     * @param money 商品价格
     */
    public void saleProduct(Double money);

    /**
     * 售后服务
     * @param money 服务价格
     */
    public void afterService(Double money);
}
