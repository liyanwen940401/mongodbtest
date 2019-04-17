package com.liyw.mongodbtest;

import com.liyw.mongodbtest.domain.Customer;
import com.liyw.mongodbtest.inter.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongodbtestApplication implements CommandLineRunner {

    static Logger logger = LoggerFactory.getLogger(MongodbtestApplication.class);

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongodbtestApplication.class, args);
        logger.info("【【【【【SpringBoot整合Mongodb启动完成.】】】】】");
    }

    @Override
    public void run(String... args) throws Exception {
        // 删除全部
        //customerRepository.deleteAll();
        // 添加一条数据
       // customerRepository.save(new Customer("于", "起宇",System.currentTimeMillis()));
        //批量添加
        /*Customer c1= new Customer("李","四",System.currentTimeMillis()-1000*60*60*36);
        Customer c2= new Customer("张","三",System.currentTimeMillis()-1000*60*60*99);
        Customer c3= new Customer("王","五",System.currentTimeMillis()-1000*60*60*111);
        Customer c4= new Customer("柳","船",System.currentTimeMillis()-1000*60*60*222);
        Customer c5= new Customer("张","一",System.currentTimeMillis()-1000*60*60*55);
        Customer c6= new Customer("鸿","名",System.currentTimeMillis()-1000*60*60*83);
        Customer c7= new Customer("张","催",System.currentTimeMillis()-1000*60*60*53);
        Customer c8= new Customer("刘","起",System.currentTimeMillis()-1000*60*60*84);
        Customer c9= new Customer("苏","菲",System.currentTimeMillis()-1000*60*60*44);
        Customer c10= new Customer("赵","来",System.currentTimeMillis()-1000*60*60*84);
        customerRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));*/
        // 查询全部
        List<Customer> s = customerRepository.findAll();
        //根据条件查询
        customerRepository.findAll();
    }
}
