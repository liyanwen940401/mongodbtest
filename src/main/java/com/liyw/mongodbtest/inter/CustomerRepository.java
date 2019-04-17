package com.liyw.mongodbtest.inter;

import com.liyw.mongodbtest.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

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
 * @date 2019/4/3 11:13
 */
public interface CustomerRepository extends MongoRepository<Customer,String> {

    /*Page<Customer> findByAccount(String account, Pageable pageable);*/
}
