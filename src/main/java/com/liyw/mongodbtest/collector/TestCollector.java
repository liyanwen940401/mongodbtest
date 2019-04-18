package com.liyw.mongodbtest.collector;

import com.alibaba.fastjson.JSONObject;
import com.liyw.mongodbtest.domain.Customer;
import com.liyw.mongodbtest.inter.CustomerRepository;
import com.liyw.mongodbtest.mqfile.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author liyw
 * @version V1.0
 * @date 2019/4/18 11:01
 */
@RestController
@RequestMapping("test")
public class TestCollector {
    static Logger logger = LoggerFactory.getLogger(TestCollector.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/updateCustomer")
    public Object sendMessage() {
        Customer c1= new Customer("李","四sssssss",System.currentTimeMillis()-1000*60*60*36);
        Customer result = customerRepository.save(c1);
        if(!Objects.isNull(result.getId())){
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, JSONObject.toJSONString(result));
        }
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, result);
        return "ok";
    }
}
