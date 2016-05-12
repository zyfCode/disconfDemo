package com.example.disconf.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfItem;

/**
 * 金融宝服务，计算一天赚多少钱
 *
 * @author liaoqiqi
 * @version 2014-5-16
 */
//@Service
public class BaoBaoService {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaoBaoService.class);

    public static final String key = "moneyInvest";

    @Value(value = "2000d")
    private Double moneyInvest;


    @Override
	public String toString() {
		return "BaoBaoService [moneyInvest=" + moneyInvest + "]";
	}

	/**
     * 投资的钱，分布式配置 <br/>
     * <br/>
     * 这里切面无法生效，因为SpringAOP不支持。<br/>
     * 但是这里还是正确的，因为我们会将值注入到Bean的值里.
     *
     * @return
     */
    @DisconfItem(key = key)
    public Double getMoneyInvest() {
        return moneyInvest;
    }

    
    
    public void setMoneyInvest(Double moneyInvest) {
        this.moneyInvest = moneyInvest;
        LOGGER.info("i' m here: setting moneyInvest");
    }

}
